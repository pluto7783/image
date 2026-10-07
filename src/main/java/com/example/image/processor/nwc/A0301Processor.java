package com.example.image.processor.nwc;

import com.example.image.constant.DocumentCode;
import com.example.image.processor.UploadProcessor;
import com.example.image.upload.dto.UploadRequest;
import com.example.image.upload.service.UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class A0301Processor implements UploadProcessor {

	private final UploadService uploadService;

	@Override
	public Set<String> getSupportedCodes() {
		return Set.of(
                DocumentCode.A0301
        );
	}

	@Override
	public void beforeSetting(UploadRequest request) {
		// 업무별 업로드 전 설정을 수행합니다.
        log.info("[{}] beforeSetting : {}", this.getClass().getName(), request.getJobType());
	}

	@Override
	public String fileUpload(UploadRequest request) {
        log.info("fileUpload : {}", request.getJobType());
		return uploadService.upload(request.getContent());
	}

	@Override
	public String afterUpload(UploadRequest request, String uploadResult) {
        log.info("afterUpload : {}", request.getJobType());
		// 업무별 업로드 후처리를 수행합니다.
		return uploadResult;
	}
}
