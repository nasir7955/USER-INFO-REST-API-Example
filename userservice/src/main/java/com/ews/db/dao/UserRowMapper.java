package com.ews.db.dao;

import com.ews.userservice.model_pojos.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserData> {

    @Override
    public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserData user = new UserData();
        user.setUserName(rs.getString("userName"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNo(rs.getString("phoneNo"));

        user.setImage(rs.getString("image"));


        return user;

    }
}
