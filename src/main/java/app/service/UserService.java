package app.service;

import app.dto.SignUpDTO;
import app.model.User;
import app.persistence.UserJpaController;
import java.util.List;

public class UserService extends UserUtils implements CrudService {

    private UserJpaController userJpaController = new UserJpaController();

    @Override
    public Object create(Object object) {
        User userCreated = null;
        SignUpDTO userdto = (SignUpDTO) object;
        try {
            userCreated = new User(
                    userdto.getUsername(),
                     userdto.getPassword());
            userJpaController
                    .create(userCreated);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // userJpaController.create(new User(0l,"admin", "admin"));
        return userCreated;
    }

    @Override
    public Object get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
