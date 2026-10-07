package com.example.image.upload.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UploadRepository {

	public String save(String content) {
		// 저장소 연동 전 단계의 샘플 응답
		return "업로드 처리 완료: " + content;
	}
}
