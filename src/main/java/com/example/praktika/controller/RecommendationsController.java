package com.example.praktika.controller;

import com.example.praktika.entity.RecommendationsEntity;
import com.example.praktika.response.BaseResponse;
import com.example.praktika.response.DataResponse;
import com.example.praktika.response.ListResponse;
import com.example.praktika.service.RecommendationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/recommendations")
@AllArgsConstructor
@Tag(name="Советы", description="Взаимодействие с советами")
public class RecommendationsController {
    private final RecommendationsService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть все советы"
    )
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<RecommendationsEntity>(true, "Список советов", service.findAll()));
    }

    @PostMapping
    @Operation(
            summary = "Добавить совет"
    )
    public ResponseEntity<BaseResponse> save(@RequestBody RecommendationsEntity recommendations) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<RecommendationsEntity>(true, "Совет сохранен", service.save(recommendations)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/update")
    @Operation(
            summary = "Обновить совет"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody RecommendationsEntity recommendations) {
        try {
            service.update(recommendations);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Совет сохранен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
}
