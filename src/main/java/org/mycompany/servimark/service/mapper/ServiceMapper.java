package org.mycompany.servimark.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.model.Service;
import org.mycompany.servimark.service.model.UserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceMapper {
    Service serviceDTOToService(ServiceDTO serviceDTO);

    ServiceDTO serviceToServiceDTO(Service service);

    UserService userServiceDTOToUserService(ServiceDTO serviceDTO);
}
