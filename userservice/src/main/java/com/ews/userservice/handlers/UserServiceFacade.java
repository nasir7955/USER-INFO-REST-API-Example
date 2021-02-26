package com.ews.userservice.handlers;

import com.ews.userservice.dao.AbstractUserInfo;
import com.ews.userservice.exception.UserExceptionHandler;
import com.ews.userservice.model_pojos.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserServiceFacade {

    @Autowired
    private UserExceptionHandler exceptionHandler;

    public UserInfoResponse execute(AbstractUserInfo userInfo, Map<String,String> header){


        userInfo.process();
        

        return null;


    }

}
