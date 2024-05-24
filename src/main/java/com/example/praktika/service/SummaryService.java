package com.example.praktika.service;

import com.example.praktika.entity.SummaryEntity;
import com.example.praktika.repository.SummaryRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class SummaryService {
    private final SummaryRepo repo;

    public List<SummaryEntity> findAll() {
        return repo.findAll();
    }

    public Optional<SummaryEntity> findById(Long id) {
        return repo.findById(id);
    }

    public SummaryEntity save (@Valid SummaryEntity data) {
        return repo.save(data);
    }

    public void update (SummaryEntity data) {
        repo.save(data);
    }

    public List <SummaryEntity>findByActivities(String activities) {
        return repo.findByActivities(activities);
    }
        public List <SummaryEntity>findBySkills(String skills){
            return repo.findBySkills(skills);
    }

    public void delete (Long id) {repo.deleteById(id);}
}
