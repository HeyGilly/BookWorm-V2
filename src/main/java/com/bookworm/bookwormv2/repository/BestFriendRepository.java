package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.BestFriends;
import com.bookworm.bookwormv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BestFriendRepository extends JpaRepository<BestFriends,Long> {
    boolean existsByUserAndStatus(User user, String status);

    List<BestFriends> findAllByUser(User user);
    BestFriends findByFriendshipId(Long friendshipId);

    List<BestFriends> findBestFriendsByFriend_IdOrUser_Id(long friend, long user);
}
