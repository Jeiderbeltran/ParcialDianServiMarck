package org.mycompany.servimark.order.management;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mycompany.servimark.order.OrderDTO;
import org.mycompany.servimark.order.OrderExternalAPI;
import org.mycompany.servimark.order.OrderInternalAPI;
import org.mycompany.servimark.order.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderManagement implements OrderInternalAPI, OrderExternalAPI {
    
    private final OrderRepository orderRepository;

    public OrderManagement(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> saveOrder(OrderDTO orderDTO) {
        try {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            System.out.println("entra1");
            System.out.println(orderDTO.serviceId());
            System.out.println(orderDTO.scheduledDate());
            if(countOrdersByServiceIdAndScheduledDate(orderDTO.serviceId(), orderDTO.scheduledDate()) > 0) {
                map.put("message", "Ya existe una orden para el servicio en la fecha seleccionada");
                map.put("status", false);
                return new ResponseEntity<>(map,HttpStatus.CONFLICT);
            }
            System.out.printf("entra2");
            map.put("data", null);
            map.put("status", "true");
            map.put("message", "Orden guardada exitosamente");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("message", "Error al guardar la orden"+e.getMessage());
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Long countOrdersByServiceIdAndScheduledDate(String serviceId, LocalDateTime scheduledDate) {
        return orderRepository.countOrdersByServiceIdAndScheduledDate(serviceId, scheduledDate);
    }
}
