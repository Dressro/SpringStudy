package com.file.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.file.updown.util.FileValidator;
import com.file.updown.util.UploadFile;

@Controller
public class HomeController {

	@Autowired
	private FileValidator fileValidator;

	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}

	// 서버 요청을 위한 request
	// ModelAndView를 통해 값을 전달하기 위한 model
	// uploadfile 객체에 담아서 보냈으므로 uploadfile
	// 스프링 데이터 검증을 위한 BindingResult
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {

		// 업로드 파일과 BindingResult를 보내서 조건에 맞는 에러가 있는지 확인
		fileValidator.validate(uploadFile, result);

		if (result.hasErrors()) {
			//에러가 있다면
			return "upload";
		}
		
		// 파일 데이터를 받기위해 MultipartFile 타입의 file을 만들음
		MultipartFile file = uploadFile.getMpfile();
		// .getOriginalFilename() 메소드를 통해 파일 데이터의 이름을 가지고 옴
		String name = file.getOriginalFilename();
		
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// 파일의 내용을 저장!
			inputStream = file.getInputStream();
			// 파일 업로드 경로 설정
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			// 파일경로에 디렉토리가 없으면 디렉토리 생성
			File storage = new File(path);
			if (!storage.exists()) {
				storage.mkdirs();
			}
			
			// 파일 경로에 파일이 존재 하지 않을 경우 생성
			File newFile = new File(path + "/" + name);
			if (!newFile.exists()) {
				// 빈 파일을 만들어 냄
				newFile.createNewFile();
			}
			
			// 빈 파일에 inputStream을 읽어서 복사함
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] b = new byte[(int) file.getSize()];

			while ((read = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("fileObj", fileObj);
		return "download";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request,HttpServletResponse response,String name) {
		byte[] down = null;
		try {
			// 다운로드 받을 파일의 경로를 설정
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			// 파일을 가지고 옴
			File file = new File(path + "/" +name);
			
			// 해당 파일을 Byte배열로 복사해서 전달 해 줌
			down = FileCopyUtils.copyToByteArray(file);
			// 해당 파일의 이름을 가지고 옴
			// "8859_1" 은 ISO 8859-1이며 첫 256개의 유니 코드 문자로 나타낼 수 있는 1 바이트 인코딩
			String filename = new String(file.getName().getBytes(),"8859_1");
			
			// 응답 헤더 설정
			// Content-Disposition는 Http Response Body에 오는 컨텐츠의 기질/ 성형을 알려주는 속성
			// 하지만 Content-Disposition 에 attacment를 주는 경우는 특수한 경우로
			// 뒤에 filename을 함께 주면 body에 오는 값을 다운 받으라는 뜻이 된다
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			// 다운을 위한 파일크기를 알려줌
			response.setContentLength(down.length);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return down;
	}

}
