package com.file.updown.util;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// Validator : 어플리케이션에서 사용하는 객체를 검증 할 수 있는 기능 제공
@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	// 파일이 업로드가 안되어 있는 상태로 send를 눌렀는지 확인
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		UploadFile file = (UploadFile) target;
		
		// 파일 업로드가 안되어 있으면
		if(file.getMpfile().getSize() == 0) {
			// 필드에 대한 에러코드 메시지를 보내줌
			errors.rejectValue("mpfile", "fileNPE","Please select a file");
		}
	}

}
