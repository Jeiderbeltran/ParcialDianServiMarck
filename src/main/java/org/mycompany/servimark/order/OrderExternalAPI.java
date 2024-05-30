package org.mycompany.servimark.order;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface OrderExternalAPI {
    ResponseEntity<Map<String,Object>> saveOrder(OrderDTO orderDTO);
}
