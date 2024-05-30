package org.mycompany.servimark.order;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderDTO(
    @NotBlank(message = "El id del servicio no puede estar vació")
    String serviceId,
    @NotNull(message = "LA fecha de programación no puede estar vacía")
    LocalDateTime scheduledDate
) {
    public OrderDTO(String serviceId, LocalDateTime scheduledDate) {
        this.serviceId = serviceId;
        this.scheduledDate = scheduledDate;
    }
}
