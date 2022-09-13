package ru.arifolth.pulkovo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.arifolth.pulkovo.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    private Map<String, User> userMap = new HashMap<>();

    public UserDAOImpl() {
    }

    @Override
    public ResponseEntity<User> createUser(User body) {
        userMap.put(body.getUsername(), body);

        return  new ResponseEntity<>(body,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        ResponseEntity<Void> responseEntity;

        User user = userMap.remove(username);
        if(user != null)
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        else
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return  responseEntity;
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        ResponseEntity<User> responseEntity;

        User user = userMap.get(username);
        if(user != null)
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        else
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return  responseEntity;
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, User body) {
        ResponseEntity<Void> responseEntity;

        User user = userMap.get(username);
        if(user != null) {
            user.setUserStatus(body.getUserStatus());
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }
}
