package com.ews.userservice.dao;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserInfoResponse;

public abstract class AbstractUserInfo {
    UserDto dto = null;
    public abstract UserInfoResponse process();
    public void setDto(UserDto dto){
        this.dto = dto;

    }

    public UserDto getDto(){
        return dto;

    }
}
