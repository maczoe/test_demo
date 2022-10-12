package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MatchPatternDTO {
    private String name;
    private String value;
    private String defaultValue;
    List<MatchersDTO> matchers;
}
