package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.exception.BadRequestException;
import com.ews.userservice.exception.BusinessValidationException;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserInfoDelete implements AbstractUserInfo {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();
        userDao = (UserDao)dto.get("dao");
        int rowsDeleted = userDao.deleteUser(user.getUserName());
        if(rowsDeleted == 0){
            return new UserInfoResponse(user.getUserName(), " Was Not Found", LocalDateTime.now());
        }
        return new UserInfoResponse(user.getUserName(), " Was Deleted", LocalDateTime.now());

    }
}
