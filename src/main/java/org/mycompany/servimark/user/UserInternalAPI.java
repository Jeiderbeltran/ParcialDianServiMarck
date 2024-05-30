package org.mycompany.servimark.user;

import org.mycompany.servimark.user.dto.UserDTO;

public interface UserInternalAPI {
    UserDTO getUserById(String userId);

    String getUserIdByIdentification(String identification);

    String getUserIdByEmail(String email);

    Long getUserStatusByUserId(String Id);
}
