package com.example.praktika.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Summary")
public class SummaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", example = "A-124523")
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,20}")
    @Schema(description = "Фамилия", example = "Виаичм")
    private String lastname;
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,20}")
    @Schema(description = "Имя", example = "Аипеа")
    private String name;
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,20}")
    @Schema(description = "Отчество", example = "Итпттп")
    private String surname;
    @NotBlank()
    @Pattern(regexp = "[{1,20}]")
    @Schema(description = "Дата рождения", example = "21412441")
    private String birthday;
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,40}")
    @Schema(description = "Деятельность", example = "Итпттп")
    private String activities;
    @JsonIgnore
    @OneToMany(mappedBy = "summary", cascade = CascadeType.ALL)
    private List<SummaryEntity> summary;
}
