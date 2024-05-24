package com.example.praktika.controller;

import com.example.praktika.entity.SummaryEntity;
import com.example.praktika.entity.VacancyEntity;
import com.example.praktika.response.BaseResponse;
import com.example.praktika.response.DataResponse;
import com.example.praktika.response.ListResponse;
import com.example.praktika.service.VacancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vacancy")
@AllArgsConstructor
@Tag(name="Вакансии", description="Взаимодействие с вакансиями")
public class VacancyController {
    private final VacancyService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть все вакансии"
    )
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<VacancyEntity>(true, "Список вакансий", service.findAll()));
    }

    @PostMapping
    @Operation(
            summary = "Добавить вакансию"
    )
    public ResponseEntity<BaseResponse> save(@RequestBody VacancyEntity vacancy) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<VacancyEntity>(true, "Вакансия сохранена", service.save(vacancy)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/update")
    @Operation(
            summary = "Обновить вакансию"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody VacancyEntity vacancy) {
        try {
            service.update(vacancy);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Вакансия сохранена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/search")
    @Operation(
            summary = "Поиск вакансий по названию"
    )
    public ResponseEntity<BaseResponse> search(@RequestParam String activities) {
            return ResponseEntity.ok(
                    new ListResponse<VacancyEntity>(true, "вакансии", service.findByActivities(activities)));
        }

    @GetMapping("/search2")
    @Operation(
            summary = "Поиск вакансий c определенным графиком"
    )
    public ResponseEntity<BaseResponse> search2(@RequestParam String chart) {
        return ResponseEntity.ok(
                new ListResponse<VacancyEntity>(true, "вакансии", service.findByChart(chart)));
    }

    @GetMapping("/search4")
    @Operation(
            summary = "Поиск вакансии с возможностью работать дистанционно"
    )
    public ResponseEntity<BaseResponse> search4(@RequestParam String remoteWork) {
        return ResponseEntity.ok(
                new ListResponse<VacancyEntity>(true, "вакансии", service.findByRemoteWork(remoteWork)));
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить вакансию"
    )
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Вакансия удалена"));

    }
}
