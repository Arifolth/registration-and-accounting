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

package ru.arifolth.pulkovo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private LocalDate birthday;

    private Integer age;

    private String email;

    private Integer userStatus;

    public UserEntity() {
    }

    public UserEntity(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.birthday = user.getBirthday();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.userStatus = user.getUserStatus();
    }

    public UserEntity(Integer id, String username, LocalDate birthday, Integer age, String email, Integer userStatus) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.age = age;
        this.email = email;
        this.userStatus = userStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(this.id, userEntity.id) &&
                Objects.equals(this.username, userEntity.username) &&
                Objects.equals(this.birthday, userEntity.birthday) &&
                Objects.equals(this.age, userEntity.age) &&
                Objects.equals(this.email, userEntity.email) &&
                Objects.equals(this.userStatus, userEntity.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, birthday, age, email, userStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserEntity {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public User getUser() {
        User user = new User();

        user.setId(this.id);
        user.setUsername(this.username);
        user.setBirthday(this.birthday);
        user.setAge(this.age);
        user.setEmail(this.email);
        user.setUserStatus(this.userStatus);

        return user;
    }
}
