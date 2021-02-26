package com.ews.userservice.controllers;

import com.ews.userservice.dao.*;
import com.ews.userservice.dto.UserDto;
import com.ews.userservice.enums.ActionEnum;
import com.ews.userservice.handlers.UserServiceFacade;
import com.ews.userservice.model_pojos.UserData;
import com.ews.userservice.model_pojos.UserInfoResponse;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/user/info/v1")
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
    @RequestMapping (value = "/adduser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json")
    public ResponseEntity<String> addUser(@RequestBody UserData requestBody, @ModelAttribute HashMap<String,
                String> header){
        //Todo: validate data & header based on business rules, not known as of now
        //Todo: Validate dupe request using Idempotency key, not in scope
        log.info("Create request received");

        //todo: remove temp
        userDao.creatTable();
        ///
        UserDto dto = new UserDto();
        dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.CREATE.name());
        AbstractUserInfo userInfo = new UserInfoAdd();
        userInfo.setDto(dto);



        UserInfoResponse userInfoSuccess = userFacade.execute(userInfo, header);
        log.info(userInfoSuccess);

        HttpStatus status = HttpStatus.OK;


        return new ResponseEntity<>(userInfoSuccess.toString(), status);

    }

    @RequestMapping(value ="/allusers_inquiry", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity <List<UserData>> getAllUsers(@ModelAttribute HashMap<String, String> header){

        //validate header and auth

        log.info("Retrieve all users request receive");

        //todo: remove temp
        try {
            userDao.creatTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ///
        UserDto dto = new UserDto();
        //dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.RETRIEVEALL.name());
        AbstractUserInfo userInfo = new UserInfoAll(userDao);
        userInfo.setDto(dto);
        UserInfoResponse userInfoSuccess = userFacade.execute(userInfo, header);

        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(status);

    }


    @RequestMapping(value ="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <String> deleteUser(@ModelAttribute HashMap<String, String> header,
                                              @PathVariable ("id") String userName){

        //validate header and auth

        UserData requestBody = new UserData();
        requestBody.setUserName(userName);
        HttpStatus status = HttpStatus.OK;
        UserDto dto = new UserDto();
        dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.DELETE.name());
        AbstractUserInfo userInfo = new UserInfoDelete();
        userInfo.setDto(dto);
        UserInfoResponse userInfoSuccess = userFacade.execute(userInfo, header);


        return new ResponseEntity<>(status);

    }

    @RequestMapping(value ="/updateuser", method = RequestMethod.PUT)
    public ResponseEntity <String> updateUser(@ModelAttribute HashMap<String, String> header,
                                              @RequestBody UserData requestBody){

        //validate auth in header

        HttpStatus status = HttpStatus.OK;
        UserDto dto = new UserDto();
        dto.setRequest(requestBody);
        dto.setServiceType(ActionEnum.UPDATE.name());
        AbstractUserInfo userInfo = new UserInfoUpdate();
        userInfo.setDto(dto);
        UserInfoResponse userInfoSuccess = userFacade.execute(userInfo, header);

        return new ResponseEntity<>(status);

    }



}