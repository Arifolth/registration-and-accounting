package ru.arifolth.pulkovo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.arifolth.pulkovo.model.Statistics;
import ru.arifolth.pulkovo.model.UserEntity;

import java.time.LocalDate;

@Component
public class StatisticsApiDelegateImpl implements StatisticsApiDelegate {
    @Autowired
    private UserDAO userDAOImpl;

    @Autowired
    private UserEntityRepository repository;

    @Override
    public ResponseEntity<Statistics> getStatistics(Integer reqStatus, Boolean adults) {
        repository.save(new UserEntity(1,"user1", LocalDate.of(1981,02, 24), 39, "root@localhost.localdomain", 0));

        repository.save(new UserEntity(2,"user2", LocalDate.of(1982,02, 24), 39, "root@localhost.localdomain", 1));

        repository.save(new UserEntity(3,"user3", LocalDate.of(1983,02, 24), 39, "root@localhost.localdomain", 0));


        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1)");
        repository.findById(1).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByUsername('user2')");
        repository.findByUsername("user2").forEach(x -> System.out.println(x));

        return userDAOImpl.getStatistics(reqStatus, adults);
    }
}
