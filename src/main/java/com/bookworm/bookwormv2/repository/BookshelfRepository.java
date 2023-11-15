package com.bookworm.bookwormv2.repository;

import com.bookworm.bookwormv2.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {

    //== Find By genre
    List<Bookshelf> findAllByGenre(String name);
//    List<Bookshelf> findAllGenre();




}
