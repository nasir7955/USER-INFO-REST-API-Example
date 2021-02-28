package com.ews.db.dao;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserInfoDelete extends AbstractUserInfo {


    @Autowired
    private UserDao userDao;

    /*   public UserInfoAll(UserDao userDao){
           this.userDao = userDao;
       }*/
    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();
        int rowsDeleted = userDao.deleteUser(user.getUserName());
        return new UserInfoResponse(user.getUserName(), " Was Deleted", LocalDateTime.now());

    }
/*
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
    }*/
}
