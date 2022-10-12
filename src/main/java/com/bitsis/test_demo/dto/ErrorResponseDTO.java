package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponseDTO {
    List<ValidationFieldsDTO> validationFields;
    List<ErrorParametersDTO> errorParameters;
    List<DefaultErrorParametersDTO> defaultErrorParameters;
}
