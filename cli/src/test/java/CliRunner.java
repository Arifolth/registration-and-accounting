import ru.arifolth.pulkovo.api.UserApi;
import ru.arifolth.pulkovo.model.User;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;


public class CliRunner {

    public static void main(final String[] args) {

        final UserApi api = new UserApi();
        User body = new User();
        body.setUsername("aeiou");
        body.setUserStatus(0);
        body.setAge(12);
        body.email("root@localhost.localdomain");
        body.birthday(LocalDate.of(2020, 1, 8));
        User response = api.createUser(body);
        System.out.println("createUser: " + response);

        final User user = api.getUserByName("aeiou");
        System.out.println("getUserByName: " + user);

        api.updateUser(new User(), "aeiou");
        System.out.println("updateUser: " + user);

        api.deleteUser("aeiou");
        System.out.println("deleteUser: " + user);

    }
}
