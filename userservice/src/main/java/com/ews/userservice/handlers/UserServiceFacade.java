package com.ews.userservice.handlers;

import com.ews.db.jpa.AbstractUserInfo;
import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserResponseInterface;
import org.apache.commons.chain.Context;

import org.springframework.stereotype.Component;

@Component
public class UserServiceFacade implements UserServiceFacadeInterface {

    public boolean execute(Context context) {
        UserDto dto = (UserDto)context;
        AbstractUserInfo userInfo = dto.getUserInfo();
        UserResponseInterface response = userInfo.process(dto);
        dto.setResponse(response);
        return true;
    }

}
