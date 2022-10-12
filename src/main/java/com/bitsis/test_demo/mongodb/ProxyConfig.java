package com.bitsis.test_demo.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class ProxyConfig {

    @Id
    private long id;

    private String tenant;

}
