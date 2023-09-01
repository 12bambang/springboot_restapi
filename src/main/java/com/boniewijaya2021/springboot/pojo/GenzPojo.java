package com.boniewijaya2021.springboot.pojo;

import com.boniewijaya2021.springboot.entity.Tblitem;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GenzPojo {
//    private UUID idUser;
    private String name;
    private Integer age;
    private String city;
    private String consumerType;
    private List<Tblitem>salesItem;

//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class ItemPojo implements Serializable {
////        private UUID idItem;
//        private String name;
//        private List<String> models;
//        private UUID idUser;
//
//    }
}
