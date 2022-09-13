package ru.arifolth.pulkovo.api;

import org.springframework.http.ResponseEntity;
import ru.arifolth.pulkovo.model.User;

public interface UserDAO {
    public ResponseEntity<User> createUser(User body);
    public ResponseEntity<Void> deleteUser(String username);
    public ResponseEntity<User> getUserByName(String username);
    public ResponseEntity<Void> updateUser(String username, User body);

}
