package com.example.image.upload.service;

import org.springframework.stereotype.Service;

@Service
public class UploadService {

	public String upload(String fileName) {
		// 샘플용 처리: 실제 파일 저장 없이 업로드 결과 문구만 반환합니다.
		return "업로드 완료: " + fileName;
	}
}
