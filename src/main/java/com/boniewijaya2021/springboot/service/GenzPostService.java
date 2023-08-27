package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Tblgenz;
import com.boniewijaya2021.springboot.entity.Tblitem;
import com.boniewijaya2021.springboot.pojo.GenzPojo;
import com.boniewijaya2021.springboot.repository.GenzRepository;
import com.boniewijaya2021.springboot.repository.ItemRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenzPostService {

    @Autowired
    private GenzRepository genzRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<MessageModel> addDataSoal1(GenzPojo genzPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            Tblgenz tblgenz = new Tblgenz();
            tblgenz.setName(genzPojo.getName());
            tblgenz.setAge(genzPojo.getAge());
            tblgenz.setCity(genzPojo.getCity());
            tblgenz.setConsumerType(genzPojo.getConsumerType());
            Tblgenz saveTblgenz = genzRepository.save(tblgenz);


            for (GenzPojo.ItemPojo itemPojo: genzPojo.getSalesItem()) {
                Tblitem tblitem = new Tblitem();
                tblitem.setName(itemPojo.getName());
                tblitem.setModels( String.join(",",itemPojo.getModels()));
                tblitem.setIdUser(saveTblgenz.getIdUser());
                itemRepository.save(tblitem);
            }




            msg.setStatus(true);
            msg.setMessage("Success");
//            result.put("data", tblSales);
            msg.setData(genzPojo);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
