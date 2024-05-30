package org.mycompany.servimark.service.dto;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.mycompany.servimark.user.dto.UserDTO;

public record HistoryServiceDTO(String id,
                                String name,
                                String description,
                                BigDecimal price,
                                UserDTO user
) {
    public HistoryServiceDTO(String id, String name, String description, BigDecimal price) {
        this(id, name, description, price, null);
    }
}
