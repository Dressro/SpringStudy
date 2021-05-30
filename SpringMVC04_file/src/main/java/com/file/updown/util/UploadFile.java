package com.file.updown.util;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	// 이름
	private String name;
	private String desc;
	// 파일 업로드는 multipart/form-data 형태로 인코딩해서 넘어옴
	// multipart/form-data 형태를 받아주기 위한 MultipartFile 타입을 생성
	private MultipartFile mpfile;

	public UploadFile() {

	}

	public UploadFile(String name, String desc, MultipartFile mpfile) {

		this.name = name;
		this.desc = desc;
		this.mpfile = mpfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MultipartFile getMpfile() {
		return mpfile;
	}

	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}

}
