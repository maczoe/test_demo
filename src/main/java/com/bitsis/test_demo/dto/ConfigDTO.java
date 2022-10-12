package com.bitsis.test_demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ConfigDTO implements Serializable {
    private String _id;
    private String tenant;
    private IncomingConfigDTO incomingConfig;
    private OutcomeConfigDTO outcomeConfig;
}
