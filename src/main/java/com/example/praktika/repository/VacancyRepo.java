package com.example.praktika.repository;

import com.example.praktika.entity.SummaryEntity;
import com.example.praktika.entity.VacancyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepo extends JpaRepository<VacancyEntity, Long> {

    List<VacancyEntity> findByActivities(String activities);

    List<VacancyEntity> findByChart(String chart);

    List<VacancyEntity> findByRemoteWork(String remoteWork);
}
