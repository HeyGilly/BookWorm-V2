package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.LikedReview;
import com.bookworm.bookwormv2.models.Reviews;
import com.bookworm.bookwormv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedRepository extends JpaRepository<LikedReview, Long> {

    LikedReview findByUserAndReview(User user, Reviews review);

}
