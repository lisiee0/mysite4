package com.javaex.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	public void restore(MultipartFile file) {
		System.out.println("fileservice/restore()");
		
		
		
		// 파일을 하드디스크에 저장(운영내용)
		
		// 원본파일이름
		String orgName= file.getOriginalFilename();
		
		// 확장자
		String exName= orgName.substring(orgName.lastIndexOf("."));

		// 저장파일이름
		String saveName= System.currentTimeMillis()+UUID.randomUUID().toString()+exName;
		System.out.println(saveName);
		
		
		
		// db에 저장
		
		
		
		
	}
}
