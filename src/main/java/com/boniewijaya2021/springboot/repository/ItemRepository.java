package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Tblgenz;
import com.boniewijaya2021.springboot.entity.Tblitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Tblitem, UUID> {

    List<Tblitem> getByIdUser(UUID idUser);
}
