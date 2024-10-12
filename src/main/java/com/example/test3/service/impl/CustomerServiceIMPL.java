package com.example.test3.service.impl;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;
import com.example.test3.entity.Customer;
import com.example.test3.repo.CustomerRepo;
import com.example.test3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDto customerDto) {

        Customer customer=new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerSalery(),
                customerDto.getNic(),
                customerDto.isActive()
        );
        customerRepo.save(customer);
        return customerDto.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalery(customerUpdateDTO.getCustomerSalery());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName();
        }else {
            throw new RuntimeException("no data found that id");
        }
    }
}

