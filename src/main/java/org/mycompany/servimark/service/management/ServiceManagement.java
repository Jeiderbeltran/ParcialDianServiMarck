package org.mycompany.servimark.service.management;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mycompany.servimark.core.management.StorageService;
import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.ServiceExternalAPI;
import org.mycompany.servimark.service.ServiceInternalAPI;
import org.mycompany.servimark.service.dto.CategoryDTO;
import org.mycompany.servimark.service.dto.HistoryServiceDTO;
import org.mycompany.servimark.service.mapper.ServiceMapper;
import org.mycompany.servimark.service.model.ImageService;
import org.mycompany.servimark.service.model.UserService;
import org.mycompany.servimark.service.repository.ServiceRepository;
import org.mycompany.servimark.service.repository.UserServiceRepository;
import org.mycompany.servimark.user.UserInternalAPI;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

@Service
public class ServiceManagement implements ServiceInternalAPI, ServiceExternalAPI {

    private final ServiceRepository serviceRepository;
    private final UserServiceRepository userServiceRepository;
    private final ServiceMapper serviceMapper;
    private final StorageService storageService;
    private final UserInternalAPI userInternalAPI;

    public ServiceManagement(ServiceRepository serviceRepository, 
                             ServiceMapper serviceMapper, 
                             UserServiceRepository userServiceRepository,
                             StorageService storageService,
                             UserInternalAPI userInternalAPI) {
        this.serviceMapper = serviceMapper;
        this.serviceRepository = serviceRepository;
        this.userServiceRepository = userServiceRepository;
        this.storageService = storageService;
        this.userInternalAPI = userInternalAPI;
    }

    public ResponseEntity<Map<String, Object>> getServices() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("data", serviceRepository.findAll());
        map.put("status", "true");
        map.put("message", "Servicios obtenidos exitosamente");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Map<String,Object>> saveService(ServiceDTO serviceDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(getServiceByName(serviceDTO.user().getId(),serviceDTO.name()) > 0){
            map.put("message", "Servicio con este nombre ya existe ");
            map.put("status", false);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }

      if(userInternalAPI.getUserStatusByUserId(serviceDTO.user().getId()) == 4){
        map.put("message", "este usuario no esta activo ");
        map.put("status", false);
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
      }
      
        UUID serviceId = UUID.randomUUID();
        //Create entity service
        org.mycompany.servimark.service.model.Service service = serviceMapper.serviceDTOToService(serviceDTO);
        service.setId(serviceId.toString());
        //Save entity service
        ServiceDTO save = serviceMapper.serviceToServiceDTO(serviceRepository.save(service));
        //Save entity user_service
        saveUserService(serviceDTO.user(), service);
        //Save images
        // saveImages(serviceDTO.images(), service);
        //Response
        map.put("data", serviceDTO);
        map.put("status", "true");
        map.put("message", "Servicio guardado exitosamente");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    private void saveImages(List<MultipartFile> imageService, org.mycompany.servimark.service.model.Service service) {
        for (MultipartFile file : imageService) {
            try {
                String path = storageService.store(file);
                ImageService image = new ImageService();
                image.setPath(path);
                image.setService(service);
                image.setIsMain(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveUserService(User user, org.mycompany.servimark.service.model.Service service) {
        UserService userService = new UserService();
        userService.setService(service);
        userService.setUser(user);
        userServiceRepository.save(userService);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> getHistoryServiceByUser(UserDTO userDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<HistoryServiceDTO> historyServiceDTO = serviceRepository.findByUserId(userDTO.id());
        for (HistoryServiceDTO hsDTO : historyServiceDTO) {
        }
        map.put("data", historyServiceDTO);
        map.put("status", "true");
        map.put("message", "Historial de servicios obtenido exitosamente...");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getServicesByCategoryId(CategoryDTO categoryDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("data", serviceRepository.findByCategoryId(categoryDTO.id()));
        map.put("status", "true");
        map.put("message", "Servicios obtenidos exitosamente");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    public Long getServiceByName(String userId,String name) {
        return serviceRepository.findServiceByUserIdAndName(userId,name);
    }
}
