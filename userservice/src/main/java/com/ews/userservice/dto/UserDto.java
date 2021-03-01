package com.ews.userservice.dto;

import com.ews.db.jpa.AbstractUserInfo;

import com.ews.userservice.model_pojos.UserResponseInterface;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;


public class UserDto extends ContextBase implements Serializable {
    private static final long serialVersionUID = 1L;
    private String serviceType;
    private AbstractUserInfo userInfo;
    private UserResponseInterface response;
    private Map<String,String> headers;
    private HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public UserResponseInterface getResponse() {
        return response;
    }

    public void setResponse(UserResponseInterface response) {
        this.response = response;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public AbstractUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(AbstractUserInfo userInfo) {
        this.userInfo = userInfo;
    }


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
