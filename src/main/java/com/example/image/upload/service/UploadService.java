package com.example.image.upload.service;

import com.example.image.upload.repository.UploadRepository;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

	private final UploadRepository uploadRepository;

	public UploadService(UploadRepository uploadRepository) {
		this.uploadRepository = uploadRepository;
	}

	public String upload(String content) {
		return uploadRepository.save(content);
	}
}
