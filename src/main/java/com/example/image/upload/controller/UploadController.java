package com.example.image.upload.controller;

import com.example.image.upload.dto.UploadRequest;
import com.example.image.upload.dto.UploadResponse;
import com.example.image.upload.service.UploadUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/uploads")
@RequiredArgsConstructor
@Slf4j
public class UploadController {

	private final UploadUseCase uploadUseCase;

    @GetMapping("")
    public String uploadMain() {
        return "upload/main";
    }

	@PostMapping("/uploadJsonToWas")
    @ResponseBody
	public UploadResponse uploadJsonToWas(@RequestBody UploadRequest request) {
        log.info("uploadJsonToWas Param : {}", request);

        // Controller -> UseCase -> Service 호출 샘플
        String message = uploadUseCase.uploadJsonToWas(request);

        return UploadResponse.builder()
                .resultCode("S")
                .resultMsg(message)
                .build();
	}
}
