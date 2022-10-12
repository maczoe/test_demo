package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeadersDTO {
    private String name;
    private String value;
    private String defaultValue;
    private String type;
}
