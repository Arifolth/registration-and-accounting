/**
 *     Copyright (C) 2022 - 2025 Alexander Nilov
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */


package ru.arifolth.pulkovo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.arifolth.pulkovo.model.Status;
import ru.arifolth.pulkovo.model.User;
import ru.arifolth.pulkovo.model.UserEntity;

import java.util.Optional;


@Component
public class UserApiDelegateImpl implements UserApiDelegate {

    @Autowired
    private UserEntityRepository repository;

    @Override
    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntity<>(repository.save(new UserEntity(user)).getUser(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) {
        Optional<UserEntity> userEntity = repository.findById(id);
        ResponseEntity<User> responseEntity;

        if(userEntity.isEmpty()) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity<>(userEntity.get().getUser(), HttpStatus.OK);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<Status> updateUser(Integer id, Status status) {
        ResponseEntity<Status> responseEntity;

        Optional<UserEntity> userEntity = repository.findById(id);
        if(userEntity.isPresent()) {
            Status statusObject = new Status();
            statusObject.setUserOldStatus(userEntity.get().getUserStatus());
            userEntity.get().setUserStatus(status.getUserNewStatus());
            statusObject.setId(userEntity.get().getId());
            statusObject.setUserNewStatus(userEntity.get().getUserStatus());
            repository.save(userEntity.get());

            responseEntity = new ResponseEntity<>(statusObject, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }
}
