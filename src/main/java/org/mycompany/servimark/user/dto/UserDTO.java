package org.mycompany.servimark.user.dto;

import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.user.model.IdentificationType;
import org.mycompany.servimark.user.model.UserStatus;
import org.mycompany.servimark.user.model.UserType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
    String id, 
    UserStatus userStatus,
    @NotNull(message = "El tipo de identificación no puede estar en blanco")
    IdentificationType identificationType, 
    @NotBlank(message = "La identificación no puede estar en blanco")
    String identification, 
    @NotBlank(message = "El primer nombre no puede estar en blanco")
    String firstName, 
    String middleFirstName, 
    @NotBlank(message = "El primer apellido no puede estar en blanco")
    String lastName, 
    String middleLastName,
    @NotNull(message = "El tipo de usuario no puede estar en blanco")
    UserType userType,
    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    String username,
    @NotBlank(message = "El teléfono no puede estar en blanco")
    String phone,
    String phoneHome,
    @NotNull(message = "El municipio no puede estar en blanco")
    Municipality municipality,
    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El correo electrónico no es válido")
    String email,
    String address,
    String password) {

    public UserDTO (String id, UserStatus userStatus, IdentificationType identificationType, String identification, String firstName, String middleFirstName, String lastName, String middleLastName, UserType userType, String username, String phone, String phoneHome, Municipality municipality, String email, String address, String password) {    
        this.id = id;
        this.userStatus = userStatus;
        this.identificationType = identificationType;
        this.identification = identification;
        this.firstName = firstName;
        this.middleFirstName = middleFirstName;
        this.lastName = lastName;
        this.middleLastName = middleLastName;
        this.userType = userType;
        this.username = username;
        this.phone = phone;
        this.phoneHome = phoneHome;
        this.municipality = municipality;
        this.email = email;
        this.address = address;
        this.password = password;
    }
}
