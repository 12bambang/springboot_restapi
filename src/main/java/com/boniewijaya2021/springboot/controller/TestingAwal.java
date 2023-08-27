package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.service.TestPostService;
import com.boniewijaya2021.springboot.service.TestService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class TestingAwal {

    @Autowired
    private TestService testService;

    @Autowired
    private TestPostService testPostService;

    @GetMapping("/get/dataTesting")
    public ResponseEntity getDataTesting(@RequestParam UUID idBarang ){
        ResponseEntity responseEntity = testService.getDataTesting(idBarang);
        return responseEntity;
    }

//    @PostMapping("/post/dataTesting")
//   private ResponseEntity addDataTesting(@RequestBody )
}