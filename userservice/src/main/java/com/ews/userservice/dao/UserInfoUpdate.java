package com.ews.userservice.dao;

import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class UserInfoUpdate extends AbstractUserInfo {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process() {
        HttpStatus status = HttpStatus.OK;
        UserData user = (UserData) this.getDto().getRequest();
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            status = HttpStatus.BAD_REQUEST;
            return new UserInfoResponse(user.getUserName(),"Was not Updated", LocalDateTime.now());
        }
        return new UserInfoResponse(user.getUserName(),"Was Updated", LocalDateTime.now());
    }
}
