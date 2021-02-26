package com.ews.userservice.dao;

import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class UserInfoDelete extends AbstractUserInfo {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process() {
        UserData user = (UserData) this.getDto().getRequest();
        HttpStatus status = HttpStatus.OK;


        try {
            userDao.deleteUser(user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
            status = HttpStatus.NOT_FOUND;
            return new UserInfoResponse(user.getUserName(), " Was Not Deleted", LocalDateTime.now());
        }
        return new UserInfoResponse(user.getUserName(), " Was Deleted", LocalDateTime.now());
    }
}
