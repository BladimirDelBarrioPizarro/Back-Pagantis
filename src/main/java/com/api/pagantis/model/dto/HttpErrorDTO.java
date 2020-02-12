package com.api.pagantis.model.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class HttpErrorDTO {
    private Integer code;
    private String statusText;
    private String url;
    private String message;
    private String method;
    private String date;
}
