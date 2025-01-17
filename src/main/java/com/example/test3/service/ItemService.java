package com.example.test3.service;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.paginated.PaginatedResponseItemDto;
import com.example.test3.dto.request.ItemSaveRequestDTO;
import com.example.test3.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);

    String deleteItem(int itemId);

    List<ItemGetResponseDTO> getAllItemByActiveStatus(boolean active);

    PaginatedResponseItemDto getAllItemByActiveStatuswithPaginated(boolean active, int page, int size);
}
