package com.example.praktika.controller;

import com.example.praktika.entity.SummaryEntity;
import com.example.praktika.response.BaseResponse;
import com.example.praktika.response.DataResponse;
import com.example.praktika.response.ListResponse;
import com.example.praktika.service.SummaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/summary")
@AllArgsConstructor
@Tag(name="Резюме", description="Взаимодействие с резюме")
public class SummaryController {
    private final SummaryService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть все резюме"
    )
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<SummaryEntity>(true, "Список резюме", service.findAll()));
    }

    @PostMapping
    @Operation(
            summary = "Добавить резюме"
    )
    public ResponseEntity<BaseResponse> save(@RequestBody SummaryEntity summary) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<SummaryEntity>(true, "Резюме сохранено", service.save(summary)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/update")
    @Operation(
            summary = "Обновить резюме"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody SummaryEntity summary) {
        try {
            service.update(summary);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Резюме сохранено"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/search")
    @Operation(
            summary = "Поиск резюме по названию вида деятельности"
    )
    public ResponseEntity <BaseResponse> search(@RequestParam String activities){
        return ResponseEntity.ok(
                new ListResponse<SummaryEntity>(true, "резюме", service.findByActivities(activities)));
    }
    @GetMapping("/search3")
    @Operation(
            summary = "Поиск резюме пользователя с определенными навыками"
    )
    public ResponseEntity <BaseResponse> search3(@RequestParam String skills){
        return ResponseEntity.ok(
                new ListResponse<SummaryEntity>(true, "резюме", service.findBySkills(skills)));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить резюме"
    )
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                new BaseResponse(true, "Резюме удалено"));
    }
}
