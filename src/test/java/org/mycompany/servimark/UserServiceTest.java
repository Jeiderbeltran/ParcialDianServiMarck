package org.mycompany.servimark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.service.model.UserService;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.management.UserManagement;
import org.mycompany.servimark.user.model.IdentificationType;
import org.mycompany.servimark.user.model.UserStatus;
import org.mycompany.servimark.user.model.UserType;
import org.mycompany.servimark.user.repository.UserRepositoty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserServiceTest {
    @Mock
    private UserRepositoty userRepository;

    @InjectMocks
    private UserManagement userManagement;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser_UserWithExistingEmail() {
        // Arrange
           UserDTO userDTO = new UserDTO("1", new UserStatus("Activo"), new IdentificationType("Cedula"), "123456", 
                "John", "Middle", "Doe", "MiddleLastName", new UserType("Admin"), "john_doe", 
                "123456789", "987654321", new Municipality("Municipality"), 
                "jhond@ensename.net", "Address", "password");
        
        when(userRepository.findByEmail(userDTO.email())).thenReturn("1");
        // Act
        ResponseEntity<Map<String, Object>> response = userManagement.saveUser(userDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Usuario con este correo ya existe", response.getBody().get("message"));
        assertEquals(false, response.getBody().get("status"));
    }

    @Test
    public void testSaveUser_UserWithExistingIdentification() {
        // Arrange
        UserDTO userDTO = new UserDTO("1", new UserStatus("Activo"), new IdentificationType("Cedula"), "123456", 
                "John", "Middle", "Doe", "MiddleLastName", new UserType("Admin"), "john_doe", 
                "123456789", "987654321", new Municipality("Municipality"), 
                "jhond@ensename.net", "Address", "password"); 

        when(userRepository.findByIdentification(userDTO.identification())).thenReturn("1");

        // Act
        ResponseEntity<Map<String, Object>> response = userManagement.saveUser(userDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Usuario con esta identificación ya existe", response.getBody().get("message"));
        assertEquals(false, response.getBody().get("status"));
    }
}
