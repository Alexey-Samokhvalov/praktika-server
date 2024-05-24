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
@Table(name = "summary")
public class SummaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", example = "A-124523")
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,100}")
    @Schema(description = "Фамилия Имя Отчество", example = "Виаичм Авуаыуа Ваыааы")
    private String lns;
    @NotBlank()
    @Pattern(regexp = "[1-9.]{1,20}")
    @Schema(description = "Дата рождения", example = "21412441")
    private String birthday;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,40}")
    @Schema(description = "Название сферы деятельности", example = "Итпттп")
    private String activities;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я1-9]{1,40}")
    @Schema(description = "Опыт работы", example = "Итпттп")
    private String experience;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,40}")
    @Schema(description = "Образование", example = "Итпттп")
    private String education;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я,]{1,80}")
    @Schema(description = "Навыки", example = "Итпттп")
    private String skills;
    @NotBlank()
    @Pattern(regexp = "[1-9]{1,40}")
    @Schema(description = "Контакты", example = "Итпттп")
    private String contacts;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,100}")
    @Schema(description = "Описание", example = "Итпттп")
    private String description;
    @ManyToOne
    @JoinColumn(name = "users")
    @Schema(description = "id пользователя", example = "A-124523")
    private UsersEntity users;

}
