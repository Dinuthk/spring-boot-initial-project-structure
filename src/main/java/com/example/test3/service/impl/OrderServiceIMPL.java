package com.example.test3.service.impl;

import com.example.test3.dto.request.RequestOrderSaveDTO;
import com.example.test3.entity.Order;
import com.example.test3.entity.OrderDetails;
import com.example.test3.repo.CustomerRepo;
import com.example.test3.repo.ItemRepo;
import com.example.test3.repo.OrderDetailsRepo;
import com.example.test3.repo.OrderRepo;
import com.example.test3.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional // table 2kka data save wenwa ekk ho aulk giyot adungena process ekm ntr kr gnnw
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order  order = new Order(
                customerRepo.getById(requestOrderSaveDTO.getCustomers()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);
        //order ekk tynwa nm order details ekk hdnn oni item eka set krla
        if(orderRepo.existsById(order.getOrderId())){
            //requestOrderSaveDTO-> orderDetails

            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){
                    }.getType());
            //order details adala row walata galapena order id ek set krnn oni dn
            for (int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;
    }
}
