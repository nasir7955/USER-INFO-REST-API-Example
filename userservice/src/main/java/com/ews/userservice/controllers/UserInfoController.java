package com.ews.userservice.controllers;

import com.ews.db.jpa.UserDao;
import com.ews.db.jpa.*;
import com.ews.userservice.dto.UserDto;
import com.ews.userservice.enums.ActionEnum;
import com.ews.userservice.handlers.UserServiceFacade;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Log4j2
@RestController
@ComponentScan (basePackages = "com.ews")
@RequestMapping("/users/info/v1")
public class UserInfoController {

    @Autowired
    private UserServiceFacade userFacade;

    @Autowired
    private UserDao userDao;

    /**
     * Add new user
     * @param requestBody
     * @return
     */
    @PostMapping (value = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUser(@RequestBody UserData requestBody, @ModelAttribute HashMap<String,
                String> header){
        //Todo: validate data & header based on business rules, not known as of now
        //Todo: Validate dupe request using Idempotency key, not in scope

        log.info("Create request received");

        UserDto dto = new UserDto();
        dto.setHeaders(header);
        dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.CREATE.name());
        AbstractUserInfo userInfo = new UserInfoAdd();
        dto.setUserInfo(userInfo);

        dto.put("dao", userDao);
        boolean userInfoSuccess = userFacade.execute(dto);
        UserInfoResponse userInfoResponse = (UserInfoResponse)dto.getResponse();
        log.info(userInfoResponse);

        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(userInfoResponse, status);

    }

    @GetMapping(value ="/users_inquiry", produces = "application/json")
    public ResponseEntity <List<UserData>> getAllUsers(@ModelAttribute HashMap<String, String> header) throws Exception {

        //validate header and auth, send header to jwt validation service

        log.info("Retrieve all users request receive");

        UserDto dto = new UserDto();

        dto.setServiceType(ActionEnum.RETRIEVEALL.name());
        dto.setHeaders(header);
        AbstractUserInfo userInfo = new UserInfoFindAll();
        dto.setUserInfo(userInfo);
        dto.put("dao", userDao);
        boolean userInfoSuccess = userFacade.execute(dto);

        UserInfoResponse infoResponse = (UserInfoResponse)dto.getResponse();

        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(infoResponse.getUserDataList(),status);

    }


    @DeleteMapping(value ="/delete/{id}")
    public ResponseEntity <String> deleteUser(@ModelAttribute HashMap<String, String> header,
                                              @PathVariable ("id") String userName){

        //todo: validate header and auth, send header to jwt validation service

        UserData requestBody = new UserData();
        requestBody.setUserName(userName);
        HttpStatus status = HttpStatus.OK;
        UserDto dto = new UserDto();
        dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.DELETE.name());
        AbstractUserInfo userInfo = new UserInfoDelete();
        dto.setUserInfo(userInfo);
        dto.put("dao", userDao);
        boolean ok = userFacade.execute(dto);
        UserInfoResponse response = (UserInfoResponse)dto.getResponse();

        return new ResponseEntity<>(response.getMessage(),status);

    }

    @PutMapping(value ="/updateuser", consumes = "application/json", produces = "application/json")
    public ResponseEntity <Object> updateUser(@ModelAttribute HashMap<String, String> header,
                                              @RequestBody UserData requestBody){

        //todo: validate header and auth, send header to jwt validation service

        HttpStatus status = HttpStatus.OK;
        UserDto dto = new UserDto();
        dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.UPDATE.name());
        AbstractUserInfo userInfo = new UserInfoUpdate();
        dto.setUserInfo(userInfo);
        dto.put("dao", userDao);
        userFacade.execute(dto);
        UserInfoResponse response = (UserInfoResponse)dto.getResponse();

        return new ResponseEntity<>(response,status);

    }



}