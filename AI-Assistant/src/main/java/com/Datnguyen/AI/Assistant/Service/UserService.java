package com.Datnguyen.AI.Assistant.Service;

import com.Datnguyen.AI.Assistant.Entity.UserEntity;
import com.Datnguyen.AI.Assistant.Repository.UserJDBCRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserEntity userEntity;
    private UserJDBCRepo userJDBCRepo;
    public UserService(UserEntity userEntity, UserJDBCRepo userJDBCRepo){
        this.userEntity = userEntity;
        this.userJDBCRepo = userJDBCRepo;
    }

    public UserEntity createUser(String loginname, String password, String username){
        return new UserEntity(username, loginname, password);
    }

    public UserEntity login(String loginname, String password){
        List<UserEntity>allUsers = userJDBCRepo.getAllUser();
        for (UserEntity userInList : allUsers){
            if (userInList.getLoginname().equals(loginname) && userInList.getPassword().equals(password)){
                return userInList;
            }
        }
        return null;
    }
}
