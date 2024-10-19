package com.example.test3.repo;

import com.example.test3.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Query("SELECT c FROM Customer c WHERE c.active = :activeStatus")
    List<Customer> findAllByActiveEquals(@Param("activeStatus") boolean activeStatus);
    //customize quary method ekk api hdnwa active status eke ewa filter krla gnn
    //metndi api kamati ek dnn ba name ekt. cr+space eken suggest wena glpen ek gnn oni
}
