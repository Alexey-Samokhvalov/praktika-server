package com.example.praktika.controller;

import com.example.praktika.entity.UsersEntity;
import com.example.praktika.response.BaseResponse;
import com.example.praktika.response.DataResponse;
import com.example.praktika.response.ListResponse;
import com.example.praktika.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@Tag(name="Пользователи", description="Взаимодействие с пользователями")
public class UsersController {
    private final UsersService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть всех пользователей"
    )
    public ResponseEntity<ListResponse<UsersEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<UsersEntity>(true, "Список пользователей", service.findAll()));
    }

    @PostMapping
    @Operation(
            summary = "Добавить пользователя"
    )
    public ResponseEntity<DataResponse<UsersEntity>> save(@RequestBody UsersEntity book) {
        return ResponseEntity.ok(
                new DataResponse<UsersEntity>(true, "Пользователь сохранен", service.save(book)));
    }

    @PutMapping("/update")
    @Operation(
            summary = "Обновить пользователя"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody UsersEntity book) {
        service.update(book);
        return ResponseEntity.ok(
                new BaseResponse(true, "Пользователь сохранен"));
    }

}
