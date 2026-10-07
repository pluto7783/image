package com.example.image.upload.service;

import com.example.image.upload.dto.UploadRequest;
import com.example.image.processor.UploadProcessor;
import com.example.image.processor.UploadProcessorResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UploadUseCaseImpl implements UploadUseCase {

	private final UploadProcessorResolver processorResolver;

	@Override
	public String uploadJsonToWas(UploadRequest request) {
		UploadProcessor processor = processorResolver.resolve(request.getJobType());

		processor.beforeSetting(request);

		String uploadResult = processor.fileUpload(request);

		return processor.afterUpload(request, uploadResult);
	}
}
