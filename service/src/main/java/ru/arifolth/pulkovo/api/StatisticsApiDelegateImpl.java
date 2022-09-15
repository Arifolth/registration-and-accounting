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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.arifolth.pulkovo.model.Statistics;
import ru.arifolth.pulkovo.model.User;
import ru.arifolth.pulkovo.model.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Component
public class StatisticsApiDelegateImpl implements StatisticsApiDelegate {

    public static final int ADULT_AGE = 18;
    @Autowired
    private UserEntityRepository repository;

    @Override
    public ResponseEntity<Statistics> getStatistics(Integer reqStatus, Boolean adults) {
        Statistics statistics = new Statistics();
        statistics.setOverall((int) repository.count());

        List<UserEntity> userEntities = repository.findByUserStatus(reqStatus);
        List<User> statusUsers = new ArrayList<>();
        userEntities.forEach(userEntity -> statusUsers.add(userEntity.getUser()));
        statistics.setStatusUsers(statusUsers);

        if(adults) {
            Iterable<UserEntity> foundEntities = repository.findAll();
            List<User> ageUsers = new ArrayList<>();
            for (UserEntity userEntity : foundEntities) {
                if (userEntity.getAge() > ADULT_AGE) {
                    ageUsers.add(userEntity.getUser());
                }
            }
            statistics.setAgeUsers(ageUsers);
        }

        statistics.setMidAge((int) userEntities.stream().mapToInt(UserEntity::getAge).average().getAsDouble());

        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
