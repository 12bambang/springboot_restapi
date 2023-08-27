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
@Table(name = "tbl_genz2", schema = "sample")
public class Tblgenz2 implements Serializable {
//    @Id
//    @Column(name = "id_penjualan", nullable = false)
//    private Integer idPenjualan;
    //soal 2

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_user", nullable = false)
    private UUID idUser;

    @Column(name = "name_user", nullable = false)
    private String name;

    @Column(name ="age_user", nullable = false)
    private Integer age;

    @Column(name = "city_user", nullable = false)
    private String city;

    @Column(name = "consumer_type", nullable = false)
    private String consumerType;
    ;

}
