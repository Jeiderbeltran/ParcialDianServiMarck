package org.mycompany.servimark.order.repository;

import java.time.LocalDateTime;

import org.mycompany.servimark.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("""
    SELECT COUNT(os)
    FROM OrderService os
    WHERE os.service.id = :serviceId AND os.scheduledDate = :scheduledDate
""")
Long countOrdersByServiceIdAndScheduledDate(@Param("serviceId") String serviceId, @Param("scheduledDate") LocalDateTime scheduledDate);
}
