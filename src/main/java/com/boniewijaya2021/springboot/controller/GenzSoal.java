package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.pojo.GenzPojo;
import com.boniewijaya2021.springboot.pojo.GenzPojo2;
import com.boniewijaya2021.springboot.service.GenzPostService;
import com.boniewijaya2021.springboot.service.GenzService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class GenzSoal {

    @Autowired
    private GenzService genzService;

    @Autowired
    private GenzPostService genzPostService;

    @GetMapping("/get/dataSoal1")
    public ResponseEntity getDataSoal1(@RequestParam UUID idUser ){
        ResponseEntity responseEntity = genzService.getDataSoal1(idUser);
        return responseEntity;
    }

    @PostMapping("/post/Soal1")
    private ResponseEntity<MessageModel> addSoal1(@RequestBody GenzPojo genzPojo) {
        ResponseEntity responseEntity = genzPostService.addDataSoal1(genzPojo);
        return responseEntity;
    }

    @GetMapping("/get/dataSoal2")
    public ResponseEntity getDataSoal2( @RequestParam UUID idUser) {
        ResponseEntity responseEntity = genzService.getDataSoal2(idUser);
        return responseEntity;
    }
    @PostMapping("/post/dataSoal2")
    private ResponseEntity<MessageModel> addDataSoal2(@RequestBody GenzPojo2 genzPojo2) {
        ResponseEntity responseEntity = genzPostService.addDataSoal2(genzPojo2);
        return responseEntity;
    }
}



