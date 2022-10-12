package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OutcomeConfigDTO {
    private String outcomeEndpoint;
    private String method;
    List<HeadersDTO> headers;
    List<BodyParametersDTO> bodyParameters;
    List<QueryParametersDTO> queryParameters;
}
