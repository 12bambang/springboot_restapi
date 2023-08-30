package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Tblgenz2;
import com.boniewijaya2021.springboot.entity.Tblitem;
import com.boniewijaya2021.springboot.entity.Tblsocialmedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SocialMediaRepository extends JpaRepository<Tblsocialmedia, UUID> {
    List<Tblsocialmedia> getByIdUser(UUID idUser);
}
