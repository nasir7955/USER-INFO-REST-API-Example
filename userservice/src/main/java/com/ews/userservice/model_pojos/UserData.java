package com.ews.userservice.model_pojos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
public class UserData {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;

    @JsonProperty(required = false)
    @Lob
    private String image;

    private String password;

}