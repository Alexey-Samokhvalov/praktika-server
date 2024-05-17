package com.example.praktika.controller;

import com.example.praktika.service.SummaryService;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping
    @Operation(
            summary = "Поиск резюме по id"
    )
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<SummaryEntity>(true, "Найдено следующее резюме", service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping
    @Operation(
            summary = "Добавить резюме"
    )
    public ResponseEntity<BaseResponse> save(@RequestBody SummaryEntity summary) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<SummaryEntity>(true, "резюме сохранено", service.save(summary)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping
    @Operation(
            summary = "Обновить резюме"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody SummaryEntity summary) {
        try {
            service.update(summary);
            return ResponseEntity.ok(
                    new BaseResponse(true, "резюме сохраненоыы"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить вакансию"
    )
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.ok(new BaseResponse(true, "Вакансия удалена"));

    }
}
