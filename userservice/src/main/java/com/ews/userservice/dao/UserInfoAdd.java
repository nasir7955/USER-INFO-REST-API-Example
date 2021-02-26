package com.ews.userservice.dao;

import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class UserInfoAdd extends AbstractUserInfo {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process() {
        UserData user = (UserData) this.getDto().getRequest();

        try {
            userDao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new UserInfoResponse(user.getUserName(), " Was Not created", LocalDateTime.now());
        }

        return new UserInfoResponse(user.getUserName(), " Was created successfully", LocalDateTime.now());
    }
}
