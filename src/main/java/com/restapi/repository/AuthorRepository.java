package com.restapi.repository;

import com.restapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.name_author = ?1")
    Optional<Author> getAuthorByName_author(String name_author);
}
