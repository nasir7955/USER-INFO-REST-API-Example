package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class UserInfoFindAll implements AbstractUserInfo {


    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserInfoResponse process(UserDto dto) {
        userDao = (UserDao)dto.get("dao");
        List<UserData> userDataList = userDao.retrieveAllUsers();
        return new UserInfoResponse(null,userDataList, LocalDateTime.now());
    }
}
