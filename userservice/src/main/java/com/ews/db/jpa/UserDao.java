package com.ews.db.jpa;

import com.ews.userservice.model_pojos.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String CREATETABLE = "CREATE TABLE USERDATA (userName varchar(255) PRIMARY KEY NOT NULL , LastName varchar(255) NOT NULL, FirstName varchar(255) NOT NULL," +
            "email varchar(255) NOT NULL,phoneNo varchar(20) NOT NULL, " +
            "image BLOB(65535), password varchar(255) NOT NULL);";

    private static final String CREATEUSER = "insert into USERDATA (USERNAME, Lastname,firstname, email, phoneno, " +
            "Image, password) values (?,?,?,?,?,?,?)";
    private static final String SELECTUSERS = "Select * from USERDATA";
    private static final String DELETEUSER = "Delete from USERDATA where username = ?";
    private static final String FINDBYID   = "Select * from USERDATA Where username= ?";
    private static final String UPDATEUSER = "Update USERDATA set firstName=?, lastName =?,  email=?, password = ?, phoneNo=?, image=? where username = ?";




    public int insertUser(UserData user) {

        //test of table exists
        try {
            jdbcTemplate.execute("SELECT 1 from userData");
        } catch (Exception ex) {
            creatTable();
        }


        PreparedStatementSetter preps = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getFirstName());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getPassword());
                ps.setString(6, user.getPhoneNo());

                ps.setString(7, user.getImage());

            }
        };

        return jdbcTemplate.update(CREATEUSER, preps);


    }

    public void creatTable() {
        jdbcTemplate.update(CREATETABLE);
    }

    public List<UserData> findAllUsers() {
        return jdbcTemplate.query(SELECTUSERS, new UserRowMapper());
    }

    public List<UserData> findByID(String userName) {
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, userName);

            }
        };
        try {
            return jdbcTemplate.query(FINDBYID, preparedStatementSetter, new UserRowMapper());
        } catch (Exception ex) {
            return null;
        }


    }


    public int deleteUser(String userName) {
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, userName);

            }
        };

        int rows = jdbcTemplate.update(DELETEUSER, preparedStatementSetter);

        return rows;
    }

    public int updateUser(UserData user) {
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {

                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getPhoneNo());

                ps.setString(6, user.getImage());
                ps.setString(7, user.getUserName());

            }
        };

        int rows = jdbcTemplate.update(UPDATEUSER, preparedStatementSetter);

        return rows;
    }
}

