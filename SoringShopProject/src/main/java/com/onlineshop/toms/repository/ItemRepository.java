package com.onlineshop.toms.repository;

import com.onlineshop.toms.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
