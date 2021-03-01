package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Log4j2
@Component
public class UserInfoAdd implements AbstractUserInfo {

    private UserDao userDao;

    @Autowired
    private void setUserDao(UserDao userDao){
        this.userDao = userDao;
        log.info(" in setter method of dao" + userDao);

    }

    @Override
    public UserInfoResponse process(UserDto dto) {
        UserData user = (UserData)dto.getRequest();
        List<UserData> userList = userDao.findByID(user.getUserName());
        if (userList != null && !userList.isEmpty()){
            dto.setStatus(HttpStatus.OK);
            return new UserInfoResponse(user.getUserName(), " Already Exists", LocalDateTime.now());
        }

        int rowsAdded = userDao.insertUser(user);
        dto.setStatus(HttpStatus.CREATED);
        return new UserInfoResponse(user.getUserName(), " Was Added", LocalDateTime.now());
    }
}
