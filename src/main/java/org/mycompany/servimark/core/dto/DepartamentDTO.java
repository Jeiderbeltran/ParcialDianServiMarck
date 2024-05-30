package org.mycompany.servimark.core.dto;

import jakarta.validation.constraints.NotBlank;

public record DepartamentDTO(
    Short id,
    @NotBlank(message = "El nombre del departamento no puede estar en blanco") String name) {
    public DepartamentDTO(Short id, String name) {
        this.id = id;
        this.name = name;
    }
}
