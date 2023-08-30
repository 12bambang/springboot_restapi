package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Tblgenz;
import com.boniewijaya2021.springboot.entity.Tblgenz2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenzRepository2 extends JpaRepository<Tblgenz2, UUID> {

}
