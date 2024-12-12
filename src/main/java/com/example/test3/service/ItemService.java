package com.example.test3.service;

import com.example.test3.dto.request.ItemSaveRequestDTO;
import com.example.test3.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

}
