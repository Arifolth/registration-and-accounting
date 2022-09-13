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

import ru.arifolth.pulkovo.api.StatisticsApi;
import ru.arifolth.pulkovo.api.UserApi;
import ru.arifolth.pulkovo.model.Statistics;
import ru.arifolth.pulkovo.model.Status;
import ru.arifolth.pulkovo.model.User;

import java.time.LocalDate;


public class CliRunner {
    public static void main(final String[] args) {

        final UserApi api = new UserApi();
        User body = new User();
        body.setId(13);
        body.setUsername("aeiou");
        body.setUserStatus(0);
        body.setAge(12);
        body.email("root@localhost.localdomain");
        body.birthday(LocalDate.of(2020, 1, 8));
        User response = api.createUser(body);
        System.out.println("createUser: " + response);

        final User user = api.getUserById(13);
        System.out.println("getUserById: " + user);

        Status status = new Status();
        status.setId(13);
        status.setUserNewStatus(1);
        status = api.updateUser(status, 13);
        System.out.println("status: " + status);

        final StatisticsApi statisticsApi = new StatisticsApi();
        Statistics statistics = statisticsApi.getStatistics(13, false);
        System.out.println("statistics: " + statistics);

        api.deleteUser(13);
        System.out.println("deleteUser: " + user);

    }
}
