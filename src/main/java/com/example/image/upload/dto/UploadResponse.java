package com.example.image.upload.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UploadResponse {

    private String resultCode;
    private String resultMsg;

}
