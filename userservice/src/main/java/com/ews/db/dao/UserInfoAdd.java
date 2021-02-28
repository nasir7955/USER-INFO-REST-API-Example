package com.ews.db.dao;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;
import java.util.List;
@ComponentScan(basePackages = {"com.ews.db.dao"})
public class UserInfoAdd extends AbstractUserInfo {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();
        int rowsAdded = userDao.updateUser(user);
        return new UserInfoResponse(user.getUserName(), " Was Added", LocalDateTime.now());
    }
}
