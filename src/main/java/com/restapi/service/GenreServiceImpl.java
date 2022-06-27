package com.restapi.service;

import com.restapi.entity.Genre;
import com.restapi.error.GenreNotFoundException;
import com.restapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre fetchGenreByName(String name_genre) throws GenreNotFoundException {
        Optional<Genre> genre =
                genreRepository.getGenreByName_genre(name_genre);

        if (!genre.isPresent()) {
            throw new GenreNotFoundException("Author Not Found");
        }
        return genre.get();
    }
    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public void deleteGenreById(Long genre_id) {
        genreRepository.deleteById(genre_id);
    }

}
