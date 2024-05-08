package com.slizokav.MusicToolsRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToolDto {
    private String tool_name;
    private int cost;
    private String personUsername;

}
