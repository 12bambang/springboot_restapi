package com.boniewijaya2021.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class TestPojo {
    private String idBarang;
    private Double harga;
    private String namaBarang;
    private String penanggungJawab;
    private Date tanggalBarang;
}
