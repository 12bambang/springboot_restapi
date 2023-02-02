package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.service.SalesPostService;
import com.boniewijaya2021.springboot.service.SalesService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get")
public class SampleGet {

    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesPostService salesPostService;

    @GetMapping("/dataPenjualan")
    public ResponseEntity getDataPenjualan(@RequestParam Integer idSales ){
        ResponseEntity responseEntity = salesService.getDataPenjualan(idSales);
        return responseEntity;

    }
    @GetMapping("/dataPenjualanClass")
    public ResponseEntity getDataPenjualanDinamic( String namaSales, String namaBarang){
        ResponseEntity responseEntity = salesService.getPenjualanClassrepo(namaSales, namaBarang);
        return responseEntity;
    }

    @PostMapping("/sales")
    private ResponseEntity<MessageModel> addSales(@RequestBody TblSales tblSales) {
        ResponseEntity responseEntity = salesPostService.addDataPenjualan(tblSales);
        return responseEntity;
    }
}
