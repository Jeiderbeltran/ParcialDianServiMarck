package org.mycompany.servimark.service.dto;

public record CategoryDTO(String id,
                        String name,
                        String description
) {
    public CategoryDTO(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
