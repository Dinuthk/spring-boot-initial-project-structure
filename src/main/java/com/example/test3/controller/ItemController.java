package com.example.test3.controller;

import com.example.test3.dto.request.CustomerUpdateDTO;
import com.example.test3.dto.request.ItemSaveRequestDTO;
import com.example.test3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(
            path ="/save"
    )
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message=itemService.saveItem(itemSaveRequestDTO);
        //customerService.updateCustomer(CustomerUpdateDTO); meka mehema tibbt hari message ekk
        // widihata uda eka return krot Impl eke function eke return karana value eka return kr gnn puluwn
        return message+"Updated";
    }

}
