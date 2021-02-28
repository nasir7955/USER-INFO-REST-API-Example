package com.ews.userservice.model_pojos;

import com.ews.userservice.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userName","message", "createTimeStamp"})
@Getter
@Setter
public class UserInfoResponse implements UserResponseInterface {

    private String userName;

    private String message;
    private UserDto dto;

    private LocalDateTime createTimeStamp;
    private List<UserData> userDataList;

    public UserInfoResponse() {
    }

    public UserInfoResponse(String userName, String message, LocalDateTime createTimeStamp) {
        this.userName = userName;
        this.message = message;
        this.createTimeStamp = createTimeStamp;
    }

    public UserInfoResponse(String userName, List<UserData> userDataList, LocalDateTime createTimeStamp) {
        this.userName = userName;
        this.userDataList = userDataList;
        this.createTimeStamp = createTimeStamp;
    }
}
