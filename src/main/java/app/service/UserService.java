package app.service;

import app.dto.UserDTO;
import app.model.User;
import app.persistence.UserJpaController;

public class UserService extends UserUtils implements CrudService{
  private UserJpaController userJpaController = new UserJpaController();

    @Override
    public boolean create(Object object) {
        boolean created = false;
        UserDTO userdto = (UserDTO) object;
        try{
            userJpaController
                    .create(new User(
                            userdto.getUsername()
                            , userdto.getPassword()));
            created = true;
        }catch(Exception e){
            System.out.println(   e.getMessage());
            e.printStackTrace();
        }
       // userJpaController.create(new User(0l,"admin", "admin"));
       return created;
    }

    
    
}
