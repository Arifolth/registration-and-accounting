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

import org.springframework.http.ResponseEntity;
import ru.arifolth.pulkovo.model.Statistics;
import ru.arifolth.pulkovo.model.Status;
import ru.arifolth.pulkovo.model.User;

public interface UserDAO {
    public ResponseEntity<User> createUser(User body);
    public ResponseEntity<Void> deleteUser(Integer username);
    public ResponseEntity<User> getUserById(Integer username);
    public ResponseEntity<Status> updateUser(Integer username, Status body);

    ResponseEntity<Statistics> getStatistics(Integer reqStatus, Boolean adults);
}
