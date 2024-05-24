package com.example.praktika.repository;

import com.example.praktika.entity.SummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummaryRepo extends JpaRepository<SummaryEntity, Long> {

     List <SummaryEntity> findByActivities(String activities);

     List <SummaryEntity> findBySkills(String skills);
}