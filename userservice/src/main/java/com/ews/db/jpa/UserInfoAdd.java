package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserInfoAdd implements AbstractUserInfo {
    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();
        userDao = (UserDao)dto.get("dao");
        int rowsAdded = userDao.insertUser(user);
        return new UserInfoResponse(user.getUserName(), " Was Added", LocalDateTime.now());
    }
}
