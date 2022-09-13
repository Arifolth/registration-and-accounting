/**
 *     Copyright (C) 2022 Alexander Nilov
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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.arifolth.pulkovo.model.Statistics;
import ru.arifolth.pulkovo.model.Status;
import ru.arifolth.pulkovo.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserDAOImpl() {
    }

    @Override
    public ResponseEntity<User> createUser(User body) {
        userMap.put(body.getId(), body);

        return  new ResponseEntity<>(body,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer username) {
        ResponseEntity<Void> responseEntity;

        User user = userMap.remove(username);
        if(user != null)
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        else
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return  responseEntity;
    }

    @Override
    public ResponseEntity<User> getUserById(Integer username) {
        ResponseEntity<User> responseEntity;

        User user = userMap.get(username);
        if(user != null)
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        else
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return  responseEntity;
    }

    @Override
    public ResponseEntity<Status> updateUser(Integer username, Status body) {
        ResponseEntity<Status> responseEntity;

        User user = userMap.get(username);
        if(user != null) {
            Status status = new Status();
            status.setUserOldStatus(user.getUserStatus());
            user.setUserStatus(body.getUserNewStatus());
            status.setId(user.getId());
            status.setUserNewStatus(user.getUserStatus());

            responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @Override
    public ResponseEntity<Statistics> getStatistics(Integer reqStatus, Boolean adults) {
        Statistics statistics = new Statistics();

        for(User user: userMap.values()) {
            if(user.getUserStatus().equals(reqStatus)) {
                statistics.addStatusUsersItem(user);
            }
            if(adults && user.getAge() > 18) {
                statistics.addAgeUsersItem(user);
            }
        }
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
