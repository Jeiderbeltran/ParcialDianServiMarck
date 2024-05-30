package org.mycompany.servimark.user.management;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mycompany.servimark.user.UserExternalAPI;
import org.mycompany.servimark.user.UserInternalAPI;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.mapper.UserMapper;
import org.mycompany.servimark.user.repository.UserRepositoty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserManagement implements UserInternalAPI, UserExternalAPI {

    private final UserRepositoty userRepositoty;
    private final UserMapper userMapper;

    public UserManagement(UserRepositoty userRepositoty, UserMapper userMapper) {
        this.userRepositoty = userRepositoty;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserById(String userId) {
        return userMapper.userToUserDTO(userRepositoty.findById(userId).get());
    }

    @Override
    public ResponseEntity<Map<String, Object>> saveUser(UserDTO userDTO) {
        try {Map<String, Object> map = new LinkedHashMap<String, Object>();
            if(getUserIdByIdentification(userDTO.identification()) != null) {
                map.put("message", "Usuario con esta identificación ya existe");
                map.put("status", false);
                return new ResponseEntity<>(map, HttpStatus.CONFLICT);
            }
            if(getUserIdByEmail(userDTO.email()) != null) {
                map.put("message", "Usuario con este correo ya existe");
                map.put("status", false);
                return new ResponseEntity<>(map, HttpStatus.CONFLICT);
            }
            map.put("message", "Usuario creado con éxito");
            map.put("status", true);
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("message", "Error al crear el usuario");
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }
    }

    @Override
    public String getUserIdByIdentification(String identification) {
        return userRepositoty.findByIdentification(identification);
    }

    @Override
    public String getUserIdByEmail(String email){
        return userRepositoty.findByEmail(email);
    }

    @Override
    public Long getUserStatusByUserId(String Id){
        return userRepositoty.findUserStatusByUserId(Id);
    }
}
