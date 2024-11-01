package com.example.test3.service.impl;

import com.example.test3.dto.CustomerDto;
import com.example.test3.dto.request.CustomerUpdateDTO;
import com.example.test3.entity.Customer;
import com.example.test3.repo.CustomerRepo;
import com.example.test3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if(customerRepo.existsById((customerId))){
            Customer customer = customerRepo.getReferenceById(customerId); //cutomer ekt danwa okkma icustomerid eke tyn ewa
            CustomerDto customerDto=new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalery(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDto;
        }else {
            throw new RuntimeException("no customer found that id");
        }

    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> getAllCustomer = customerRepo.findAll();

        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(Customer i:getAllCustomer){    //i=customer or we can use any name
            CustomerDto customerDto=new CustomerDto(
                    i.getCustomerId(),
                    i.getCustomerName(),
                    i.getCustomerAddress(),
                    i.getCustomerSalery(),
                    i.getNic(),
                    i.isActive()
            );
            customerDtoList.add(customerDto);   //dto ekk return krnn oni nisa api dto ekkt eka data eka gane insert krgen
            //eka array list ekkt da gnnwa. dn aulk na eka tyenne dto type eken. eka return krnn puluwn dto widiht front ekt
        }

        return customerDtoList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "delete successfully completed"+ customerId;

        }else{
            throw new RuntimeException("Customer Id invalid");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomerByActiveStatus(boolean activeStatus) {
        // Fetch customers based on the activeStatus parameter
        List<Customer> getAllActiveCustomer = customerRepo.findAllByActiveEquals(activeStatus);

        // Convert List<Customer> to List<CustomerDto>
        List<CustomerDto> customerActiveDtoList = new ArrayList<>();
        for (Customer customer : getAllActiveCustomer) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalery(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerActiveDtoList.add(customerDto);
        }
        return customerActiveDtoList;
    }



}

