package com.example.praktika.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacancy")
public class VacancyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", example = "A-124523")
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,20}")
    @Schema(description = "Название сферы деятельности", example = "A-124523")
    private String activities;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,40}")
    @Schema(description = "Требования", example = "Agdgdgd")
    private String requirements;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,40}")
    @Schema(description = "Обязанности", example = "Agdgdgd")
    private String duties;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я1-9]{1,40}")
    @Schema(description = "Опыт", example = "Agdgdgd")
    private String experience;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,40}")
    @Schema(description = "Образование", example = "Agdgdgd")
    private String education;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я1-9]{1,40}")
    @Schema(description = "График", example = "Agdgdgd")
    private String chart;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я1-9]{1,40}")
    @Schema(description = "Зарплата", example = "Agdgdgd")
    private String salary;
    @Pattern(regexp = "[А-Я\sа-я1-9]{1,40}")
    @Schema(description = "Возможность работать дистанционно", example = "Agdgdgd")
    private String remoteWork;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,100}")
    @Schema(description = "Описание", example = "Итпттп")
    private String description;
    @ManyToOne
    @JoinColumn(name = "users")
    @Schema(description = "id пользователя", example = "A-124523")
    private UsersEntity users;
}
