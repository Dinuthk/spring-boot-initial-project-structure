package com.example.test3.repo;

import com.example.test3.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {

  //  List<Item> findByItemNameAndActiveStateEquals(String itemName, boolean activeState);

}
