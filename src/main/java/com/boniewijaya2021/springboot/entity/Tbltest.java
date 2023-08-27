package com.boniewijaya2021.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_test", schema = "sample")
public class Tbltest implements Serializable {
//    @Id
//    @Column(name = "id_penjualan", nullable = false)
//    private Integer idPenjualan;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_barang", nullable = false)
    private UUID idBarang;

    @Column(name ="harga", nullable = false)
    private Double harga;

    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;

    @Column(name = "penanggung_jawab", nullable = false)
    private String penanggungJawab;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    @Column(name = "tgl_barang", nullable = false)
    private Date tanggalBarang;


}
