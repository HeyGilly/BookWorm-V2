package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.BestFriends;
import com.bookworm.bookwormv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BestFriendRepository extends JpaRepository<BestFriends,Long> {
    boolean existsByUserAndStatus(User user, String status);

    List<BestFriends> findAllByUser(User user);

}
