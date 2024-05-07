package com.slizokav.MusicToolsRestApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BodyResponse {
    private String status;
    private String message;

}
