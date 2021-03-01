package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserInfoFindAll implements AbstractUserInfo {
    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResponse process(UserDto dto) {

        List<UserData> userDataList = userDao.retrieveAllUsers();
        return new UserInfoResponse(null,userDataList, LocalDateTime.now());
    }
}
