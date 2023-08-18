package app.service;

import app.dto.UserDTO;
import app.model.User;
import app.persistence.UserJpaController;

public class UserUtils {

    private UserJpaController userJpaController = new UserJpaController();

    public boolean authenticate(UserDTO userDTO) {
        boolean auth = false;
        //Se consulta si el username existe
        //En el caso de no existir no se puede realizar la autenticación
        if (userJpaController.exists(userDTO.getUsername())) {
            //Al existir el username se obtiene el usuario con su username
            User user = userJpaController.findUser(userDTO.getUsername());
            //Se verifican los datos para realizar la autenticación
            //En el caso de username o password diferentes no se autentica
            //En caso contrario se realiza la autenticación
            if (user.getUsername().equals(userDTO.getUsername()) 
                    && user.getPassword().equals(userDTO.getPassword())) {
                auth = true;
            }      
        }
        return auth;
    }
}
