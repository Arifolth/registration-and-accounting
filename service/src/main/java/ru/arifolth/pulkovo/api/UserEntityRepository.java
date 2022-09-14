package ru.arifolth.pulkovo.api;

import org.springframework.data.repository.CrudRepository;
import ru.arifolth.pulkovo.model.UserEntity;

import java.util.List;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {

    List<UserEntity> findByUsername(String username);

}
