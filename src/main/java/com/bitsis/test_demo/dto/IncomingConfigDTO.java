package com.bitsis.test_demo.dto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IncomingConfigDTO {
    private String incomingEndpoint;
    private List<RequestValuesDTO> requestValues;
    private ErrorResponseDTO errorResponse;
    private List<ResponseValuesDTO> responseValues;
}
