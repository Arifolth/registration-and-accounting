package ru.arifolth.pulkovo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
