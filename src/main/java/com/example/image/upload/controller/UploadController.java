package com.example.image.upload.controller;

import com.example.image.upload.dto.UploadRequest;
import com.example.image.upload.dto.UploadResponse;
import com.example.image.upload.service.UploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

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
	public UploadResponse upload(@RequestBody UploadRequest request) {
		//String message = uploadUseCase.upload(request.fileName());
        log.info("uploadJsonToWas Param : {}", request.toString());


        return UploadResponse.builder()
                .resultCode("S")
                .resultMsg("성공")
                .build();
	}

}
