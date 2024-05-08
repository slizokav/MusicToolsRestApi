package com.slizokav.MusicToolsRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToolDto {
    private String toolName;
    private int cost;
}
