package ru.arifolth.pulkovo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.arifolth.pulkovo.model.User;


@Component
public class UserApiDelegateImpl implements UserApiDelegate {

    @Autowired
    private UserDAO userDAOImpl;

    public UserApiDelegateImpl() {
    }


    @Override
    public ResponseEntity<User> createUser(User body) {
        return userDAOImpl.createUser(body);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        return userDAOImpl.deleteUser(username);
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        return userDAOImpl.getUserByName(username);
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, User body) {
        return userDAOImpl.updateUser(username, body);
    }
}
