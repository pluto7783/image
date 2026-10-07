package com.example.image.upload.service;

import com.example.image.upload.dto.UploadRequest;

public interface UploadUseCase {

	String uploadJsonToWas(UploadRequest request);

}
