package com.example.image.upload.service;

import org.springframework.stereotype.Service;

@Service
public class UploadFacade implements UploadUseCase {

	private final UploadService uploadService;

	public UploadFacade(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@Override
	public String upload(String fileName) {
		return uploadService.upload(fileName);
	}
}
