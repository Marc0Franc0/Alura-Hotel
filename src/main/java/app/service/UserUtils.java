package app.service;

import app.dto.SignInDTO;
import app.model.User;
import app.persistence.UserJpaController;

public class UserUtils {

    private UserJpaController userJpaController = new UserJpaController();

    public boolean authenticate(SignInDTO userDTO) {
        boolean auth = false;
        //Se consulta si el username existe
        //En el caso de no existir no se puede realizar la autenticación
        if (userJpaController.exists(userDTO.getUsername())) {
            //Al existir el username se obtiene el usuario con su username
            User user = userJpaController.findUser(userDTO.getUsername());
            String username = user.getUsername();
            String password = new String(user.getPassword());
            //Se verifican los datos para realizar la autenticación
            //En el caso de username o password diferentes no se autentica
            //En caso contrario se realiza la autenticación
            if (username.equals(userDTO.getUsername()) 
                    && password.equals(userDTO.getPassword())) {
                auth = true;
            }      
        }
        return auth;
    }
}
