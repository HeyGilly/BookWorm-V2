package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {

    @Query("SELECT r FROM Reviews r WHERE r.bookshelf.id = :bookId ORDER BY r.id DESC" )
    List<Reviews> findReviewByBookshelf_IdSorted(long bookId);

    @Query("SELECT r FROM Reviews r WHERE r.user.id = :userId ORDER BY r.id DESC" )
    List<Reviews> findReviewByUserIdSorted(long userId);

    Reviews findReviewById(long id);


}
