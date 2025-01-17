package com.example.test3.repo;

import com.example.test3.entity.Customer;
import com.example.test3.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findByItemNameAndActiveEquals(String itemName, boolean active);

    List<Item> findAllByActiveEquals(boolean active);

    Page<Item> findAllByActiveEquals(boolean active, Pageable pageable);

    int countAllByActiveEquals(boolean active);
}

