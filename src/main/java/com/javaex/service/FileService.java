package com.javaex.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	public void restore(MultipartFile file) {
		System.out.println("fileservice/restore()");
		
		System.out.println(file.getOriginalFilename());
		
		// 파일을 하드디스크에 저장
		
		
		
		
		// db에 저장
		
		
		
		
	}
}
