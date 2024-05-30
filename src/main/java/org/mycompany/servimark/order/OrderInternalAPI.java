package org.mycompany.servimark.order;

import java.time.LocalDateTime;

public interface OrderInternalAPI {
    Long countOrdersByServiceIdAndScheduledDate(String serviceId, LocalDateTime scheduledDate);
}
