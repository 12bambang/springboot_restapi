package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.*;
import com.boniewijaya2021.springboot.pojo.GenzPojo;
import com.boniewijaya2021.springboot.pojo.GenzPojo2;
import com.boniewijaya2021.springboot.repository.*;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenzPostService {

    @Autowired
    private GenzRepository genzRepository;

    @Autowired
    private GenzRepository2 genzRepository2;

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    @Autowired
    private WebsiteRepository websiteRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<MessageModel> addDataSoal1(GenzPojo genzPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            //save user soal 1
            Tblgenz tblgenz = new Tblgenz();
            tblgenz.setName(genzPojo.getName());
            tblgenz.setAge(genzPojo.getAge());
            tblgenz.setCity(genzPojo.getCity());
            tblgenz.setConsumerType(genzPojo.getConsumerType());
            genzRepository.save(tblgenz).returnIduser();

           //save salesitem 1
            List<Tblitem> list = genzPojo.getSalesItem();
            for (Tblitem map: list) {
                Tblitem tblitem =new Tblitem();
                tblitem.setName(genzPojo.getName());
                tblitem.setModels( String.join(",",map.getModels()));
                tblitem.setIdUser(map.getIdUser());
                itemRepository.save(tblitem);

//                Tblitem tblitem = new Tblitem()
//                tblitem.setName(itemPojo.getName());
//                tblitem.setModels( String.join(",",itemPojo.getModels()));
//                tblitem.setIdUser(returnData.getIdUser());
            }
            msg.setStatus(true);
            msg.setMessage("Success");
//            result.put("data", tblSales);
            msg.setData(genzPojo);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity<MessageModel> addDataSoal2(GenzPojo2 genzPojo2) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            //save user soal 2
            Tblgenz2 tblgenz2 = new Tblgenz2();
            tblgenz2.setName(genzPojo2.getNama());
            tblgenz2.setUsia(genzPojo2.getUsia());
            tblgenz2.setEmail(genzPojo2.getEmail());
            genzRepository2.save(tblgenz2).returnIduser2();
//            Tblgenz2 saveTblgenz2 = genzRepository2.save(tblgenz2);


            // save list user soal 2
//            List<Tblitem> list = genzPojo.getSalesItem();
//            for (Tblitem map: list) {
//                Tblitem tblitem =new Tblitem();
//                tblitem.setName(genzPojo.getName());
//                tblitem.setModels( String.join(",",map.getModels()));
//                tblitem.setIdUser(map.getIdUser());
//                itemRepository.save(tblitem);


            List<Tblwebsite> listwebsite = genzPojo2.getWebsites();
            for (Tblwebsite map: listwebsite) {
                Tblwebsite tblwebsite = new Tblwebsite();
                tblwebsite.setUrl(map.getUrl());
                tblwebsite.setDescription(map.getDescription());
                tblwebsite.setIdUser(map.getIdUser());
                websiteRepository.save(tblwebsite);


////                tblitem.setName(itemPojo.getName());
////                tblitem.setModels( String.join(",",itemPojo.getModels()));
////                tblitem.setIdUser(saveTblgenz.getIdUser());
////                itemRepository.save(tblitem)
//                tblwebsite.setUrl(itemWebsite.getUrl());
//                tblwebsite.setDescription(itemWebsite.getDescription());
//                tblwebsite.setIdUser(saveTblgenz2.getIdUser());

            }
            List<Tblsocialmedia> listsocialmedia = genzPojo2.getSocialMedia();
            for (Tblsocialmedia map : listsocialmedia) {
                Tblsocialmedia tblsocialmedia = new Tblsocialmedia();
                tblsocialmedia.setUrl(map.getUrl());
                tblsocialmedia.setDescription(map.getDescription());
                tblsocialmedia.setIdUser(map.getIdUser());
                socialMediaRepository.save(tblsocialmedia);

//                tblitem.setName(itemPojo.getName());
//                tblitem.setModels( String.join(",",itemPojo.getModels()));
//                tblitem.setIdUser(saveTblgenz.getIdUser());
//                itemRepository.save(tblitem)

            }
            msg.setStatus(true);
            msg.setMessage("Success");
//            result.put("data", tblSales);
            msg.setData(genzPojo2);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
