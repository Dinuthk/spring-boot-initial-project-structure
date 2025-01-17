package com.example.test3.dto.paginated;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
