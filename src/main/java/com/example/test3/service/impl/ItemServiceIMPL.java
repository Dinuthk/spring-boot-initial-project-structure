package com.example.test3.service.impl;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.ItemSaveRequestDTO;
import com.example.test3.dto.response.ItemGetResponseDTO;
import com.example.test3.entity.Customer;
import com.example.test3.entity.Item;
import com.example.test3.entity.enums.MeasuringUnitType;
import com.example.test3.repo.CustomerRepo;
import com.example.test3.repo.ItemRepo;
import com.example.test3.service.ItemService;
import com.example.test3.util.mappers.ItemMapper;
import com.sun.jdi.request.DuplicateRequestException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item=new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );
//        itemRepo.save(item);
//        return itemSaveRequestDTO.getItemName(); meka parana krmaya alut eka use krnw modelemap mgin
        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        if (!itemRepo.existsById(item.getItemID())){
            itemRepo.save(item);
            return item.getItemName()+"Saved sucussefully";
        }else {
            throw new DuplicateRequestException("Already added");
        }
    }


    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean isActive = true;
        List<Item> items = itemRepo.findByItemNameAndActiveEquals(itemName, isActive);

        if (!items.isEmpty()) {
            return modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {}.getType());
        } else {
            throw new RuntimeException("Item is not active or not found");
        }
    }

//    @Override
//    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
//        boolean b=true;
//        List<Item> items=itemRepo.findByItemNameAndActiveStateEquals(itemName,b);
//        if(items.size()>0){  //yata code eka speacial model mapper ekt kalim for each ekk pawichchi krpu eka meka phsuwen hdna widih
//            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
//        }
//        else {
//            throw  new RuntimeException("Item is not active");
//        }
//        return null;
//    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean isActive = true;
        List<Item> items = itemRepo.findByItemNameAndActiveEquals(itemName, isActive);

        if (!items.isEmpty()) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("Item is not active or not found");
        }
    }

    @Override
    public String deleteItem(int itemId) {
        if(itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return "delete successfully completed "+ itemId;

        }else{
            throw new RuntimeException("Customer Id invalid");
        }
    }

}
