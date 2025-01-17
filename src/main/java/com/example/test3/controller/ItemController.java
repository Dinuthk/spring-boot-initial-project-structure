package com.example.test3.controller;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.paginated.PaginatedResponseItemDto;
import com.example.test3.dto.request.ItemSaveRequestDTO;
import com.example.test3.dto.response.ItemGetResponseDTO;
import com.example.test3.service.ItemService;
import com.example.test3.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @PostMapping(
//            path ="/save"
//    )
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
//        String message=itemService.saveItem(itemSaveRequestDTO);
//        //customerService.updateCustomer(CustomerUpdateDTO); meka mehema tibbt hari message ekk
//        // widihata uda eka return krot Impl eke function eke return karana value eka return kr gnn puluwn
//        return message+"Updated";
//    }

    @PostMapping(
            path ="/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message=itemService.saveItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sucsess",message),
                HttpStatus.CREATED
        );
        return response;
    }

//    @GetMapping(
//            path = "/get-by-name",
//            params = "name"
//    )
//    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
//        return itemDTOS;
//    }
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Sucsess",itemDTOS),
                HttpStatus.OK
        );
        return response;
    }

//    @GetMapping(path = "/get-by-name-with-mapstruct", params = "name")
//    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String itemName){
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);
//        return itemDTOS;
//    }
    @GetMapping(path = "/get-by-name-with-mapstruct", params = "name")
    public ResponseEntity<StandardResponse> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Sucsess",itemDTOS),
                HttpStatus.OK
        );
    }

    //delete
//    @DeleteMapping(
//            path = "/delete-item/{id}"
//    )
//    public String deleteCustomer(@PathVariable(value = "id") int itemId){
//        String delete = itemService.deleteItem(itemId);
//        return delete;
//    }
    @DeleteMapping(
            path = "/delete-item/{id}"
    )
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id") int itemId){
        String delete = itemService.deleteItem(itemId);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Sucsess",delete),
                HttpStatus.OK
        );
    }

  //  search by special case(active status0
    @GetMapping(path = "/get-all-item-by-active-status/{status}")
    public List<ItemGetResponseDTO> getAllItemByActiveStatus(@PathVariable(value = "status") boolean active) {
        List<ItemGetResponseDTO> allItem = itemService.getAllItemByActiveStatus(active);

        return allItem;
    }

    @GetMapping(
            path = "/get-all-item-by-active-page-size-status",
            params = {"status","page","size"}
    )
    public ResponseEntity<StandardResponse> getAllItemByActiveStatus(
            @RequestParam(value = "status") boolean active,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")  int size
            ) {
        //List<CustomerDto> allItem = itemService.getAllItemByActiveStatus(active);
        PaginatedResponseItemDto paginatedResponseItemDto = itemService.getAllItemByActiveStatuswithPaginated(active,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Sucsess",paginatedResponseItemDto),
                HttpStatus.OK
        );
    }
}
