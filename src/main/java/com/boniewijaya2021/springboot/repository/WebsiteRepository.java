package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Tblitem;
import com.boniewijaya2021.springboot.entity.Tblwebsite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WebsiteRepository extends JpaRepository<Tblwebsite, UUID> {
    List<Tblwebsite> getByIdUser(UUID idUser);
}
