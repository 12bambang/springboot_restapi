package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.entity.Tblgenz;
import com.boniewijaya2021.springboot.entity.Tblitem;
import com.boniewijaya2021.springboot.pojo.GenzPojo;
import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
import com.boniewijaya2021.springboot.repository.GenzRepository;
import com.boniewijaya2021.springboot.repository.ItemRepository;
import com.boniewijaya2021.springboot.repository.SalesRepository;
import com.boniewijaya2021.springboot.repository.SalesRepositoryClass;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenzService {

//    private final GenzPojo genzPojo;
//
//    @Autowired
//    public GenzService(GenzPojo genzPojo) {
//        this.genzPojo = genzPojo;
//    }

    @Autowired
    private GenzRepository genzRepository;


    @Autowired
    private ItemRepository itemRepository;


//    public SalesService(SalesRepository salesRepository) {
//        this.salesRepository = salesRepository;
//    }

    public ResponseEntity getDataSoal1(UUID idBarang){
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Tblgenz data = genzRepository.findById(idBarang).get();
            GenzPojo genzPojo = new GenzPojo();
            genzPojo.setName(data.getName());
            genzPojo.setAge(data.getAge());
            genzPojo.setCity(data.getCity());
            genzPojo.setConsumerType(data.getConsumerType());

            List<Tblitem> byIdUser = itemRepository.getByIdUser(data.getIdUser());
            List<GenzPojo.ItemPojo> newList=new ArrayList<>();
            for (Tblitem tblitem: byIdUser){
                GenzPojo.ItemPojo itemPojo = new GenzPojo.ItemPojo();
                itemPojo.setName(tblitem.getName());
                itemPojo.setModels(Arrays.asList(tblitem.getModels().split(",")));
                newList.add(itemPojo);
            }
            genzPojo.setSalesItem(newList);


            if(data.getIdUser() ==null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                msg.setData(genzPojo);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }
    }
}

//    public ResponseEntity getPenjualanClassrepo(String namaSales, String namaBarang, Double harga){
//        Map<String, Object> result = new HashMap<>();
//        MessageModel msg = new MessageModel();
//        try {
//            List<PenjualanPojo> data = salesRepositoryClass.getDataDinamic(namaSales, namaBarang);
//            if(data.isEmpty()) {
//                msg.setStatus(true);
//                msg.setMessage("data tidak ditemukan");
//                msg.setData(null);
//                return ResponseEntity.ok().body(msg);
//            }else {
//                msg.setStatus(true);
//                msg.setMessage("Success");
//                result.put("data", data);
//                msg.setData(result);
//                return ResponseEntity.ok().body(msg);
//            }
//
//        }catch (Exception e){
//            msg.setStatus(false);
//            msg.setMessage(e.getMessage());
//            return ResponseEntity.ok().body(msg);
//
//        }
//
//
//    }

