package org.mycompany.servimark.user.mapper;

import javax.annotation.processing.Generated;
import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.IdentificationType;
import org.mycompany.servimark.user.model.User;
import org.mycompany.servimark.user.model.UserStatus;
import org.mycompany.servimark.user.model.UserType;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T20:08:06-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        UserStatus userStatus = null;
        IdentificationType identificationType = null;
        String identification = null;
        String firstName = null;
        String middleFirstName = null;
        String lastName = null;
        String middleLastName = null;
        UserType userType = null;
        String username = null;
        String phone = null;
        String phoneHome = null;
        Municipality municipality = null;
        String email = null;
        String address = null;
        String password = null;

        id = user.getId();
        userStatus = user.getUserStatus();
        identificationType = user.getIdentificationType();
        identification = user.getIdentification();
        firstName = user.getFirstName();
        middleFirstName = user.getMiddleFirstName();
        lastName = user.getLastName();
        middleLastName = user.getMiddleLastName();
        userType = user.getUserType();
        username = user.getUsername();
        phone = user.getPhone();
        phoneHome = user.getPhoneHome();
        municipality = user.getMunicipality();
        email = user.getEmail();
        address = user.getAddress();
        password = user.getPassword();

        UserDTO userDTO = new UserDTO( id, userStatus, identificationType, identification, firstName, middleFirstName, lastName, middleLastName, userType, username, phone, phoneHome, municipality, email, address, password );

        return userDTO;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.id() );
        user.setUserStatus( userDTO.userStatus() );
        user.setIdentificationType( userDTO.identificationType() );
        user.setIdentification( userDTO.identification() );
        user.setFirstName( userDTO.firstName() );
        user.setMiddleFirstName( userDTO.middleFirstName() );
        user.setLastName( userDTO.lastName() );
        user.setMiddleLastName( userDTO.middleLastName() );
        user.setUserType( userDTO.userType() );
        user.setUsername( userDTO.username() );
        user.setPhone( userDTO.phone() );
        user.setPhoneHome( userDTO.phoneHome() );
        user.setMunicipality( userDTO.municipality() );
        user.setEmail( userDTO.email() );
        user.setAddress( userDTO.address() );
        user.setPassword( userDTO.password() );

        return user;
    }
}
