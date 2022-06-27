package com.restapi.repository;

import com.restapi.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.name_genre = ?1")
    Optional<Genre> getGenreByName_genre(String name_genre);
}
