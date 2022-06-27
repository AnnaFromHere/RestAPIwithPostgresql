package com.restapi.service;

import com.restapi.entity.Author;
import com.restapi.error.AuthorNotFoundException;

public interface AuthorService {

 public Author saveAuthor(Author author);

 Author fetchAuthorByName(String name_author) throws AuthorNotFoundException;

 public void deleteAuthorById(Long author_id);
}
