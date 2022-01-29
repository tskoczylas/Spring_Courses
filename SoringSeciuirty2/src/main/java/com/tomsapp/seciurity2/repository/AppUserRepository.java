package com.tomsapp.seciurity2.repository;

import com.tomsapp.seciurity2.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {


    AppUser findAppUserByUsername(String username);
}
