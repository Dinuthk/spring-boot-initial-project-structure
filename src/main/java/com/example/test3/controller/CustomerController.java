package com.example.test3.controller;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;
import com.example.test3.service.CustomerService;
import com.example.test3.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //get-by-id
    @GetMapping(
            path = "/get-by-id",
            params="id"
    )
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId){

        CustomerDto customerDto= customerService.getCustomerById(customerId);
        return customerDto;
    }
    //get all

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDto> getAllCustomers(){
        List<CustomerDto> allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }

    //delete
    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String delete = customerService.deleteCustomer(customerId);
        return delete;
    }

    //search by special case(active status0
    @GetMapping(path = "/get-all-customer-by-active-status/{status}")
    public List<CustomerDto> getAllCustomerByActiveStatus(@PathVariable(value = "status") boolean activeStatus) {
        List<CustomerDto> allCustomers = customerService.getAllCustomerByActiveStatus(activeStatus);

        return allCustomers;
    }


}
