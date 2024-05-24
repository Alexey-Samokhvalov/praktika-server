package com.example.praktika.service;

import com.example.praktika.entity.SummaryEntity;
import com.example.praktika.entity.VacancyEntity;
import com.example.praktika.repository.VacancyRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class VacancyService {
    private final VacancyRepo repo;

    public List<VacancyEntity> findAll() {
        return repo.findAll();
    }

    public Optional<VacancyEntity> findById(Long id) {return repo.findById(id);}

    public VacancyEntity save (@Valid VacancyEntity data) {return repo.save(data);}

    public void update (VacancyEntity data) {repo.save(data);}

    public List <VacancyEntity>findByActivities(String activities){
        return repo.findByActivities(activities);
    }
    public List <VacancyEntity>findByChart(String chart){
        return repo.findByChart(chart);
    }
    public List <VacancyEntity>findByRemoteWork(String remoteWork){
        return repo.findByRemoteWork(remoteWork);
    }
    public void delete (Long id) {repo.deleteById(id);}}

