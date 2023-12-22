package com.Datnguyen.AI.Assistant.Repository;

import com.Datnguyen.AI.Assistant.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJDBCRepo extends CrudRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<UserEntity>getAllUser();
    @Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
    Optional<UserEntity> foundUser(@Param("username")String username);
}
