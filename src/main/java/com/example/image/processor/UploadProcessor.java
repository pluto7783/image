package com.example.image.processor;

import com.example.image.upload.dto.UploadRequest;
import java.util.Set;

public interface UploadProcessor {

	Set<String> getSupportedCodes();

	void beforeSetting(UploadRequest request);

	String fileUpload(UploadRequest request);

	String afterUpload(UploadRequest request, String uploadResult);
}
