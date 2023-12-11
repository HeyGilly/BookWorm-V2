package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);

    User findUserByUsername(String name);


}
