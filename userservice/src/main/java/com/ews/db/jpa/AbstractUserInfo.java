package com.ews.db.jpa;

import com.ews.userservice.dto.UserDto;
import com.ews.userservice.model_pojos.UserInfoResponse;

public interface AbstractUserInfo {
    public abstract UserInfoResponse process(UserDto dto);


}
