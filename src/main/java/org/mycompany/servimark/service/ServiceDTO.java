package org.mycompany.servimark.service;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.service.model.Category;
import org.mycompany.servimark.service.model.ImageService;
import org.mycompany.servimark.service.model.ServiceStatus;
import org.mycompany.servimark.user.model.User;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceDTO(String id,
                        @NotBlank(message = "El nombre del servicio no puede estar vacio ")
                        String name,
                        @NotBlank(message = "La descripcion no puede estar vacia")
                        String description,
                        @NotNull (message = "El precio no puede estar vacio")
                        BigDecimal price,
                        // @NotBlank(message = "El estado del servicio no puede estar vacio")
                        ServiceStatus serviceStatus,
                        // @NotNull (message = "La categoria no puede estar vacia")
                        Category category,
                        // @NotNull(message = "El municipio no debe estar vacio")
                        Municipality municipality,
                        // @NotNull(message = "El usuario no debe estar vacio")
                        User user,
                        // @NotNull(message = "La lista de imagenes no debe estar vacia")
                        List<String> images) {
    public ServiceDTO(String name, String description, BigDecimal price) {
        this(null, name, description, price, null, null, null, null, new ArrayList<>());
    }
}