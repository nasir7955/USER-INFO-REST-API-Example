package com.ews.userservice.dao;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


public class UserInfoAll extends AbstractUserInfo {

    @Autowired
    private UserDao userDao;

    public UserInfoAll(){

    }

 /*   public UserInfoAll(UserDao userDao){
        this.userDao = userDao;
    }*/
    @Override
    public UserInfoResponse process(UserDto dto) {
        List<UserData> userDataList = userDao.retrieveAllUsers();
        return new UserInfoResponse(null,userDataList, LocalDateTime.now());
    }
}
