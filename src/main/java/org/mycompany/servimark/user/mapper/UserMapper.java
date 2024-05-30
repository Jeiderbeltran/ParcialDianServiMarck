package org.mycompany.servimark.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
