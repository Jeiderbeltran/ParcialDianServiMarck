package org.mycompany.servimark.service.mapper;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.model.Category;
import org.mycompany.servimark.service.model.Service;
import org.mycompany.servimark.service.model.ServiceStatus;
import org.mycompany.servimark.service.model.UserService;
import org.mycompany.servimark.user.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T20:08:06-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service serviceDTOToService(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        Service service = new Service();

        service.setId( serviceDTO.id() );
        service.setServiceStatus( serviceDTO.serviceStatus() );
        service.setName( serviceDTO.name() );
        service.setDescription( serviceDTO.description() );
        service.setPrice( serviceDTO.price() );
        service.setCategory( serviceDTO.category() );
        service.setMunicipality( serviceDTO.municipality() );

        return service;
    }

    @Override
    public ServiceDTO serviceToServiceDTO(Service service) {
        if ( service == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String description = null;
        BigDecimal price = null;
        ServiceStatus serviceStatus = null;
        Category category = null;
        Municipality municipality = null;

        id = service.getId();
        name = service.getName();
        description = service.getDescription();
        price = service.getPrice();
        serviceStatus = service.getServiceStatus();
        category = service.getCategory();
        municipality = service.getMunicipality();

        User user = null;
        List<String> images = null;

        ServiceDTO serviceDTO = new ServiceDTO( id, name, description, price, serviceStatus, category, municipality, user, images );

        return serviceDTO;
    }

    @Override
    public UserService userServiceDTOToUserService(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        UserService userService = new UserService();

        if ( serviceDTO.id() != null ) {
            userService.setId( Long.parseLong( serviceDTO.id() ) );
        }
        userService.setUser( serviceDTO.user() );

        return userService;
    }
}
