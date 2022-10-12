package com.bitsis.test_demo.controllers;

import com.bitsis.test_demo.dto.ConfigDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ProxyController {

    @PostMapping("/proxy")
    public ResponseEntity<ConfigDTO> proxy(@RequestBody ConfigDTO configDTO) {
        return ResponseEntity.ok().body(configDTO);
    }
}
