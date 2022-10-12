package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorParametersDTO {
    private String name;
    List<MatchPatternDTO> matchPattern;
}
