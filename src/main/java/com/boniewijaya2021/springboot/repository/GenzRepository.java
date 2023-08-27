package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.entity.Tblgenz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface GenzRepository extends JpaRepository<Tblgenz, UUID> {

}
