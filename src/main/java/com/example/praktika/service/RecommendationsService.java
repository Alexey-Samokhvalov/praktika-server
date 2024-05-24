package com.example.praktika.service;

import com.example.praktika.entity.RecommendationsEntity;
import com.example.praktika.entity.SummaryEntity;
import com.example.praktika.repository.RecommendationsRepo;
import com.example.praktika.repository.SummaryRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class RecommendationsService {
    private final RecommendationsRepo repo;

    public List<RecommendationsEntity> findAll() {
        return repo.findAll();
    }

    public RecommendationsEntity save(@Valid RecommendationsEntity data) {
        return repo.save(data);
    }

    public void update(RecommendationsEntity data) {
        repo.save(data);
    }

}

