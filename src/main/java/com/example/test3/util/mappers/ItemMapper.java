package com.example.test3.util.mappers;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.response.ItemGetResponseDTO;
import com.example.test3.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    //Page<Item> items -->  List<ItemGetResponseDTO> list;
    List<ItemGetResponseDTO> ListDTOToPage(Page<Item> items);
}
