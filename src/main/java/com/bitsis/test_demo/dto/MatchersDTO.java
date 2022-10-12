package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatchersDTO {
    private String match;
    private String value;
}
