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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Tblgenz tblgenz = new Tblgenz();
            tblgenz.setName(genzPojo.getName());
            tblgenz.setAge(genzPojo.getAge());
            tblgenz.setCity(genzPojo.getCity());
            tblgenz.setConsumerType(genzPojo.getConsumerType());
            Tblgenz saveTblgenz = genzRepository.save(tblgenz);


            for (GenzPojo.ItemPojo itemPojo: genzPojo.getSalesItem()) {
                Tblitem tblitem = new Tblitem();
                tblitem.setName(itemPojo.getName());
                tblitem.setModels( String.join(",",itemPojo.getModels()));
                tblitem.setIdUser(saveTblgenz.getIdUser());
                itemRepository.save(tblitem);
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
            Tblgenz2 tblgenz2 = new Tblgenz2();
            tblgenz2.setName(genzPojo2.getNama());
            tblgenz2.setUsia(genzPojo2.getUsia());
            tblgenz2.setEmail(genzPojo2.getEmail());
            Tblgenz2 saveTblgenz2 = genzRepository2.save(tblgenz2);


            for (GenzPojo2.ItemWebsite itemWebsite : genzPojo2.getWebsites()) {
                Tblwebsite tblwebsite = new Tblwebsite();
//                tblitem.setName(itemPojo.getName());
//                tblitem.setModels( String.join(",",itemPojo.getModels()));
//                tblitem.setIdUser(saveTblgenz.getIdUser());
//                itemRepository.save(tblitem)
                tblwebsite.setUrl(itemWebsite.getUrl());
                tblwebsite.setDescription(itemWebsite.getDescription());
                tblwebsite.setIdUser(saveTblgenz2.getIdUser());
                websiteRepository.save(tblwebsite);
            }
            for (GenzPojo2.ItemSocialMedia itemSocialMedia : genzPojo2.getSocialMedia()) {
                Tblsocialmedia tblsocialmedia = new Tblsocialmedia();
//                tblitem.setName(itemPojo.getName());
//                tblitem.setModels( String.join(",",itemPojo.getModels()));
//                tblitem.setIdUser(saveTblgenz.getIdUser());
//                itemRepository.save(tblitem)
                tblsocialmedia.setUrl(itemSocialMedia.getUrl());
                tblsocialmedia.setDescription(itemSocialMedia.getDescription());
                tblsocialmedia.setIdUser(saveTblgenz2.getIdUser());
                socialMediaRepository.save(tblsocialmedia);
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
