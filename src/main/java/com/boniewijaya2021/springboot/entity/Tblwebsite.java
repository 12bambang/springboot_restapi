package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_website", schema = "sample")
public class Tblwebsite implements Serializable {
//    @Id
//    @Column(name = "id_penjualan", nullable = false)
//    private Integer idPenjualan;
    //soal 2

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_website", nullable = false)
    private UUID idWebsite;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name ="description", nullable = false)
    private String description;

    @Column(name = "id_user", nullable = false)
    private UUID idUser;

}