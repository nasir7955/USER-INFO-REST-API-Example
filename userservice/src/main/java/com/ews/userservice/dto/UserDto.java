package com.ews.userservice.dto;

import java.io.Serializable;
import java.util.HashMap;

public class UserDto extends HashMap implements Serializable {
    private static final long serialVersionUID = 1L;
    private String serviceType;

    public UserDto() {

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;

    public void setServiceType (String serviceType){
        this.serviceType = serviceType;
    }

    public void setRequest(Object userData){
        super.put("Request", userData);
    }

    public String getServiceType(){
        return serviceType;
    }

    public Object getRequest(){
        return super.get("Request");
    }
}
