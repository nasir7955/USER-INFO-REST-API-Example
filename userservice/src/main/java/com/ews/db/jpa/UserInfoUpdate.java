package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserInfoUpdate implements AbstractUserInfo {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();

        int rowsDeleted = userDao.updateUser(user);
        return new UserInfoResponse(user.getUserName(), " Was Updated", LocalDateTime.now());
    }
}
