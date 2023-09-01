package com.boniewijaya2021.springboot.pojo;

import com.boniewijaya2021.springboot.entity.Tblsocialmedia;
import com.boniewijaya2021.springboot.entity.Tblwebsite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenzPojo2 {
    //    private UUID idUser;
    private String nama;
    private Integer usia;
    private String email;
    private List<Tblwebsite> websites;
    private List<Tblsocialmedia> socialMedia;

//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class ItemWebsite implements Serializable {
//        //        private UUID idItem;
//        private String url;
//        private String description;
//        private UUID idUser;
//
//    }
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class ItemSocialMedia implements Serializable {
//        //        private UUID idItem;
//        private String url;
//        private String description;
//        private UUID idUser;
//    }
}
