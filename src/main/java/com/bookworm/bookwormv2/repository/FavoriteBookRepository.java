package com.bookworm.bookwormv2.repository;


import com.bookworm.bookwormv2.models.Bookshelf;
import com.bookworm.bookwormv2.models.FavoriteBook;
import com.bookworm.bookwormv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Long> {

    List<FavoriteBook> findAllByUserId(User userId);
}
