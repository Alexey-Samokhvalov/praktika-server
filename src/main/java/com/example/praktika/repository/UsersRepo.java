package com.example.praktika.repository;

import com.example.praktika.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepo extends JpaRepository<UsersEntity, Long> {

}
