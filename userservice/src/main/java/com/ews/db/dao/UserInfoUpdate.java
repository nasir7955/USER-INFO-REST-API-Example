package com.ews.db.dao;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserInfoUpdate extends AbstractUserInfo {



    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();
        int rowsDeleted = userDao.updateUser(user);
        return new UserInfoResponse(user.getUserName(), " Was Updated", LocalDateTime.now());
    }
/*
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
    }*/
}
