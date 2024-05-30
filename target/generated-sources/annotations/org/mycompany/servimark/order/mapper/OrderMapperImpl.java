package org.mycompany.servimark.order.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.mycompany.servimark.order.OrderDTO;
import org.mycompany.servimark.order.model.Order;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T20:08:06-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order orderDTOToOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        return order;
    }

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        String serviceId = null;
        LocalDateTime scheduledDate = null;

        OrderDTO orderDTO = new OrderDTO( serviceId, scheduledDate );

        return orderDTO;
    }
}
