package com.restapi.service;

import com.restapi.entity.Genre;
import com.restapi.error.GenreNotFoundException;

public interface GenreService {

 public Genre saveGenre(Genre genre);

 Genre fetchGenreByName(String name_genre) throws GenreNotFoundException;

 public void deleteGenreById(Long genre_id);
}
