package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Tbltest;
import com.boniewijaya2021.springboot.repository.TestRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

//    @Autowired
//    private SalesRepositoryClass salesRepositoryClass;


//    public SalesService(SalesRepository salesRepository) {
//        this.salesRepository = salesRepository;
//    }

    public ResponseEntity getDataTesting(UUID idBarang) {
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Tbltest data = testRepository.findById(idBarang).get();
            if (data.getIdBarang() == null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                msg.setData(data);
                return ResponseEntity.ok().body(msg);
            }

        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }

//        public ResponseEntity getPenjualanClassrepo (String namaSales, String namaBarang){
//            Map<String, Object> result = new HashMap<>();
//            MessageModel msg = new MessageModel();
//            try {
//                List<PenjualanPojo> data = salesRepositoryClass.getDataDinamic(namaSales, namaBarang);
//                if (data.isEmpty()) {
//                    msg.setStatus(true);
//                    msg.setMessage("data tidak ditemukan");
//                    msg.setData(null);
//                    return ResponseEntity.ok().body(msg);
//                } else {
//                    msg.setStatus(true);
//                    msg.setMessage("Success");
//                    result.put("data", data);
//                    msg.setData(result);
//                    return ResponseEntity.ok().body(msg);
//                }
//
//            } catch (Exception e) {
//                msg.setStatus(false);
//                msg.setMessage(e.getMessage());
//                return ResponseEntity.ok().body(msg);
//
//            }
//
//        }
    }
}
