package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {

}
