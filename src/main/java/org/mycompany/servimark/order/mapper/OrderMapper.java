package org.mycompany.servimark.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mycompany.servimark.order.OrderDTO;
import org.mycompany.servimark.order.model.Order;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    Order orderDTOToOrder(OrderDTO orderDTO);

    OrderDTO orderToOrderDTO(Order order);
}
