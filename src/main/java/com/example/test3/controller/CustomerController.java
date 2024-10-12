package com.example.test3.controller;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;
import com.example.test3.service.CustomerService;
import com.example.test3.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v12/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save-1")
    public String saveCustomer(@RequestBody CustomerDto customerDto){

        customerService.saveCustomer(customerDto);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO CustomerUpdateDTO){
        String message=customerService.updateCustomer(CustomerUpdateDTO);
        //customerService.updateCustomer(CustomerUpdateDTO); meka mehema tibbt hari message ekk
        // widihata uda eka return krot Impl eke function eke return karana value eka return kr gnn puluwn
        return message+"Updated";
    }

    //search
    @GetMapping(
            path = "/get-by-id",
            params="id"
    )
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId){

        CustomerDto customerDto= customerService.getCustomerById(customerId);
        return customerDto;
    }
}
