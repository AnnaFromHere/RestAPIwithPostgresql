package com.restapi.service;

import com.restapi.entity.Author;
import com.restapi.error.AuthorNotFoundException;
import com.restapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author fetchAuthorByName(String name_author) throws AuthorNotFoundException {
        Optional<Author> author =
                authorRepository.getAuthorByName_author(name_author);

        if(!author.isPresent()) {
            throw new AuthorNotFoundException("Author Not Found");
        }

        return  author.get();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long author_id) {
        authorRepository.deleteById(author_id);
    }

}
