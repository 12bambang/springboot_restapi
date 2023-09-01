package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.*;
import com.boniewijaya2021.springboot.pojo.GenzPojo;
import com.boniewijaya2021.springboot.pojo.GenzPojo2;
import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
import com.boniewijaya2021.springboot.repository.*;
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
    private GenzRepository2 genzRepository2;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SocialMediaRepository socialMediaRepository;
    @Autowired
    private WebsiteRepository websiteRepository;


//    public SalesService(SalesRepository salesRepository) {
//        this.salesRepository = salesRepository;
//    }

    public ResponseEntity getDataSoal1(UUID idUser) {
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Tblgenz data = genzRepository.findById(idUser).get();
            GenzPojo genzPojo = new GenzPojo();
            genzPojo.setName(data.getName());
            genzPojo.setAge(data.getAge());
            genzPojo.setCity(data.getCity());
            genzPojo.setConsumerType(data.getConsumerType());

            List<Tblitem> byIdUser = itemRepository.getByIdUser(data.getIdUser());
            List<Tblitem> newList = new ArrayList<>();
            for (Tblitem getuser : byIdUser) {
                Tblitem tblitem = new Tblitem();
//                GenzPojo.ItemPojo itemPojo = new GenzPojo.ItemPojo();
                tblitem.setName(tblitem.getName());
                tblitem.setModels(Arrays.asList(getuser.getModels().split(",")));
                newList.add(tblitem);
            }
            genzPojo.setSalesItem(newList);


            if (data.getIdUser() == null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                msg.setData(genzPojo);
                return ResponseEntity.ok().body(msg);
            }

        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }
    }

    public ResponseEntity getDataSoal2(UUID idUser) {
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Tblgenz2 data = genzRepository2.findById(idUser).get();
            GenzPojo2 genzPojo2 = new GenzPojo2();
            genzPojo2.setNama(data.getName());
            genzPojo2.setUsia(data.getUsia());
            genzPojo2.setEmail(data.getEmail());

            List<Tblwebsite> byIdUser = websiteRepository.getByIdUser(data.getIdUser());
            List<Tblsocialmedia> byidsosmed = socialMediaRepository.getByIdUser(data.getIdUser());
            List<GenzPojo2.ItemWebsite> newList = new ArrayList<>();
            List<GenzPojo2.ItemSocialMedia> newsosmedlist = new ArrayList<>();

            for (Tblwebsite tblwebsite : byIdUser) {
                GenzPojo2.ItemWebsite itemWebsite = new GenzPojo2.ItemWebsite();
                itemWebsite.setUrl(tblwebsite.getUrl());
                itemWebsite.setDescription(tblwebsite.getDescription());
//                itemPojo.setModels(Arrays.asList(tblitem.getModels().split(",")));
                newList.add(itemWebsite);
            }
            for (Tblsocialmedia tblsocialmedia : byidsosmed) {
                GenzPojo2.ItemSocialMedia itemSocialMedia = new GenzPojo2.ItemSocialMedia();
                itemSocialMedia.setUrl(tblsocialmedia.getUrl());
                itemSocialMedia.setDescription(tblsocialmedia.getDescription());
//                itemPojo.setModels(Arrays.asList(tblitem.getModels().split(",")));
                newsosmedlist.add(itemSocialMedia);
            }
            genzPojo2.setWebsites(newList);
            genzPojo2.setSocialMedia(newsosmedlist);
            if (data.getIdUser() == null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                msg.setData(genzPojo2);
                return ResponseEntity.ok().body(msg);
            }

        } catch (Exception e) {
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

