package com.example.praktika.repository;

import com.example.praktika.entity.VacancyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepo extends JpaRepository<VacancyEntity, Long> {

}
