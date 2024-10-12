package com.example.test3.controller;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;
import com.example.test3.service.CustomerService;
import com.example.test3.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v11/customer")
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
        customerService.updateCustomer(CustomerUpdateDTO);
        return "Updated";
    }
}
