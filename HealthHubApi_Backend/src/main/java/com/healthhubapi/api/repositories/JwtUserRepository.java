package com.healthhubapi.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthhubapi.api.model.JwtUser;

 
 
@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser, Integer> {

    List<JwtUser> findAll();

    JwtUser findByEmail(String email);

    JwtUser findUserByEmail(String email);
}
