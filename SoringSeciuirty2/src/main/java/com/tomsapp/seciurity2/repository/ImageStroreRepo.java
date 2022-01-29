package com.tomsapp.seciurity2.repository;

import com.tomsapp.seciurity2.entity.ImageStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageStroreRepo extends JpaRepository<ImageStore,Long> {
}
