package com.example.test3.service;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDto getCustomerById(int customerId);

    List<CustomerDto> getAllCustomer();

    String deleteCustomer(int customerId);

    List<CustomerDto> getAllCustomerByActiveStatus(boolean activeStatus);

}
