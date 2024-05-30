package org.mycompany.servimark.service.repository;

import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.dto.HistoryServiceDTO;
import org.mycompany.servimark.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, String> {
    @Query("""
        SELECT new org.mycompany.servimark.service.dto.HistoryServiceDTO(s.id, s.name, s.description, s.price) 
        FROM Service s
        JOIN s.userService us
        JOIN us.user u
        WHERE u.id = :userId
        """)
    List<HistoryServiceDTO> findByUserId(@Param("userId") String userId);

    @Query("""
        SELECT new org.mycompany.servimark.service.ServiceDTO(s.id, s.name, s.description, s.price) 
        FROM Service s
        WHERE s.category.id = :categoryId
        """)
    List<ServiceDTO> findByCategoryId(String categoryId);
    
    
    @Query("""
        SELECT count(s)
        FROM Service s
        JOIN UserService us ON us.service.id = s.id
        WHERE us.user.id = :userId AND s.name = :serviceName
    """)
    Long findServiceByUserIdAndName(@Param("userId") String userId, @Param("serviceName") String serviceName);
}
