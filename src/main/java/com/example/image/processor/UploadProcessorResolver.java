package com.example.image.processor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UploadProcessorResolver {

	private final Map<String, UploadProcessor> processorMap;

	public UploadProcessorResolver(List<UploadProcessor> processorMap) {
		this.processorMap = processorMap.stream()
				.flatMap(processor -> processor.getSupportedCodes().stream()
						.map(code -> Map.entry(code, processor)))
				.collect(Collectors.toMap(
                          Map.Entry::getKey
                        , Map.Entry::getValue)
                );
	}

	public UploadProcessor resolve(String jobType) {
		UploadProcessor processor = processorMap.get(jobType);
		if (processor == null) {
			throw new IllegalArgumentException("지원하지 않는 jobType입니다: " + jobType);
		}
		return processor;
	}
}
