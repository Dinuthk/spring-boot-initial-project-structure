package com.example.test3.util.mappers;

import com.example.test3.dto.response.ItemGetResponseDTO;
import com.example.test3.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
}
