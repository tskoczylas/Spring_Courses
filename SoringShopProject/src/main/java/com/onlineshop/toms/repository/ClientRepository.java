package com.onlineshop.toms.repository;

import com.onlineshop.toms.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
