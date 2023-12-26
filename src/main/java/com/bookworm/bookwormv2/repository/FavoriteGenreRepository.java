package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.FavoriteGenre;
import com.bookworm.bookwormv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteGenreRepository extends JpaRepository<FavoriteGenre, Long> {
    int countByUserFavorite(User user);
}
