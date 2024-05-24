package com.example.praktika.repository;

import com.example.praktika.entity.RecommendationsEntity;
import com.example.praktika.entity.SummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationsRepo extends JpaRepository<RecommendationsEntity, Long> {
}