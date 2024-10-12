package com.example.test3.service;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;

public interface CustomerService {
    public String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);
}
