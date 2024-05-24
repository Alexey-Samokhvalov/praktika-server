package com.example.praktika.service;

import com.example.praktika.entity.UsersEntity;
import com.example.praktika.repository.UsersRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class UsersService {
    private final UsersRepo repo;

    public List<UsersEntity> findAll() {
        return repo.findAll();
    }

    public Optional<UsersEntity> findById(Long id) {
        return repo.findById(id);
    }

    public UsersEntity save (@Valid UsersEntity data) {
        return repo.save(data);
    }

    public void update (UsersEntity data) {
        repo.save(data);
    }

}
