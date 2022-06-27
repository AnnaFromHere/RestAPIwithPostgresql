package com.restapi.controller;

import com.restapi.entity.Author;
import com.restapi.error.AuthorNotFoundException;
import com.restapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public Author saveAuthor(@RequestBody @NotNull Author author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthorById(@PathVariable("id") Long author_id) {
        authorService.deleteAuthorById(author_id);
        return "Author and all his books deleted successfully!!";
    }

    @GetMapping("/authors/name/{name}")
    public Author fetchAuthorByName(@PathVariable("name") String name_author) throws AuthorNotFoundException {
        return authorService.fetchAuthorByName(name_author);
    }
}
