package com.restapi.controller;

import com.restapi.entity.Genre;
import com.restapi.error.GenreNotFoundException;
import com.restapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/genres")
    public Genre saveGenre(@RequestBody @NotNull Genre genre) {
        return genreService.saveGenre(genre);
    }

    @DeleteMapping("/genres/{id}")
    public String deleteGenreById(@PathVariable("id") Long genre_id) {
        genreService.deleteGenreById(genre_id);
        return "Genre and all its books deleted successfully!!";
    }

    @GetMapping("/genres/name/{name}")
    public Genre fetchGenreByName(@PathVariable("name") String name_genre) throws GenreNotFoundException {
        return genreService.fetchGenreByName(name_genre);
    }
}
