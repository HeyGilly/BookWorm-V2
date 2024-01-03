package com.bookworm.bookwormv2.service;

import com.bookworm.bookwormv2.models.User;
import com.bookworm.bookwormv2.repository.BestFriendRepository;
import com.bookworm.bookwormv2.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {
    private final BestFriendRepository bestFriendRepository;
    private final UserRepository userRepository;

    public NotificationService(BestFriendRepository bestFriendRepository, UserRepository userRepository) {
        this.bestFriendRepository = bestFriendRepository;
        this.userRepository = userRepository;
    }

    public boolean hasPendingFriendRequests() {
        User currentUser = userRepository.findUserById(11);
        if (currentUser == null) {
            return false;
        }
        return bestFriendRepository.existsByUserAndStatus(currentUser, "pending");
    }
}



