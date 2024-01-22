package com.yuliayakupova.mood.repo;

import com.yuliayakupova.mood.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class UserRepository {
    private final static String  INTO_USER_DATA = """
            INSERT INTO
                User (
                    user_login,
                    user_password,
                    user_email,
                    user_personalCode,
                    user_firstName,
                    user_lastName,
                    user_dateOfBirth,
                    user_contact
             ) VALUES (
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?)
            """;

    private final static String SELECT_ALL_USERS = "SELECT * FROM User";


    private final JdbcTemplate connection;

    @Autowired
    public UserRepository(JdbcTemplate connection) {
        this.connection = connection;
    }

    public void saveUserData(final User user) {

        try{
            connection.update(INTO_USER_DATA,
                    user.getLogin(),
                    user.getPassword(),
                    user.getUserEmail(),
                    user.getPersonalCode(),
                    user.getUserFirstName(),
                    user.getUserLastName(),
                    user.getDateOfBirth().toString(),
                    user.getContact());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return connection.query(SELECT_ALL_USERS, (resultSet, rowNum) -> {
            User user = new User();
            user.setLogin(resultSet.getString("user_login"));
            user.setPassword(resultSet.getString("user_password"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setPersonalCode(resultSet.getString("user_personalCode"));
            user.setUserFirstName(resultSet.getString("user_firstName"));
            user.setUserLastName(resultSet.getString("user_lastName"));
            user.setDateOfBirth(LocalDate.parse(resultSet.getString("user_dateOfBirth")));
            user.setContact(resultSet.getString("user_contact"));
            return user;
        });
    }

    public User findById(Long id) {
        String query = "SELECT * FROM User WHERE id = ?";
        return connection.queryForObject(query, new Object[]{id}, (resultSet, rowNum) -> {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setLogin(resultSet.getString("user_login"));
            user.setPassword(resultSet.getString("user_password"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setPersonalCode(resultSet.getString("user_personalCode"));
            user.setUserFirstName(resultSet.getString("user_firstName"));
            user.setUserLastName(resultSet.getString("user_lastName"));
            user.setDateOfBirth(LocalDate.parse(resultSet.getString("user_dateOfBirth")));
            user.setContact(resultSet.getString("user_contact"));
            return user;
        });
    }
}