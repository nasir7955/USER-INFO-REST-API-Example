package com.ews.userservice.handlers;

import com.ews.userservice.dao.AbstractUserInfo;
import com.ews.userservice.dto.UserDto;
import com.ews.userservice.exception.UserExceptionHandler;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserServiceFacade implements Command {

    @Autowired
    private UserExceptionHandler exceptionHandler;

    public UserInfoResponse execute(UserDto dto, Map<String,String> header){

        AbstractUserInfo userInfo = dto.getUserInfo();
        userInfo.process(dto);
        

        return null;


    }

    @Override
    public boolean execute(Context context) {
        UserDto dto = (UserDto)context;
        AbstractUserInfo userInfo = dto.getUserInfo();
        userInfo.process(dto);
        return true;
    }
}
