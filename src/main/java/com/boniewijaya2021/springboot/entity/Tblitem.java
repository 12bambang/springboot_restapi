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
@Table(name = "tbl_item", schema = "sample")
public class Tblitem implements Serializable {
//    @Id
//    @Column(name = "id_penjualan", nullable = false)
//    private Integer idPenjualan;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_item", nullable = false)
    private UUID idItem;

    @Column(name = "name_car", nullable = false)
    private String name;

    @Column(name ="models", nullable = false)
    private String  models;

    @Column(name = "id_user", nullable = false)
    private UUID idUser;

}
