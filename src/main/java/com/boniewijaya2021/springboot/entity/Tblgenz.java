package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_genz", schema = "sample")
public class Tblgenz implements Serializable {
//    @Id
//    @Column(name = "id_penjualan", nullable = false)
//    private Integer idPenjualan;
    //soal1

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
