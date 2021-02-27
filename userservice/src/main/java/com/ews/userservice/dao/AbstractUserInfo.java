package com.ews.userservice.dao;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserInfoResponse;

public abstract class AbstractUserInfo {
    public abstract UserInfoResponse process(UserDto dto);

}
