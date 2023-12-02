package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {

    List<Reviews> findReviewByBookshelf_Id(long id);
    List<Reviews> findReviewByUserId(long id);

}
