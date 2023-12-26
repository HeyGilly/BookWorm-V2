package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
