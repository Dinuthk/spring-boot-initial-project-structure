package com.example.test3.service.impl;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.ItemSaveRequestDTO;
import com.example.test3.entity.Customer;
import com.example.test3.entity.Item;
import com.example.test3.entity.enums.MeasuringUnitType;
import com.example.test3.repo.CustomerRepo;
import com.example.test3.repo.ItemRepo;
import com.example.test3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;
    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item=new Item(
                1,
                itemSaveRequestDTO.getItemName(),
                itemSaveRequestDTO.getMeasuringUnitType(),
                itemSaveRequestDTO.getBalanceQty(),
                itemSaveRequestDTO.getSupplierPrice(),
                itemSaveRequestDTO.getSellingPrice(),
                true
        );
        itemRepo.save(item);
        return itemSaveRequestDTO.getItemName();
    }
}
