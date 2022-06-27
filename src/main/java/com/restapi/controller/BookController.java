package com.restapi.controller;

import com.restapi.dto.BooksByAuthorNameWithPriceResponse;
import com.restapi.dto.BookToSaveRequest;
import com.restapi.entity.Book;
import com.restapi.error.BookNotFoundException;
import com.restapi.repository.AuthorRepository;
import com.restapi.repository.BookRepository;
import com.restapi.repository.GenreRepository;
import com.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> fetchBookList() {
        return bookService.fetchBookList();
    }

    @GetMapping("/book/{id}")
    public Book fetchBookById(@PathVariable("id") Long book_id)
            throws BookNotFoundException {
        return bookService.fetchBookById(book_id);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBookById(@PathVariable("id") Long book_id) {
        bookService.deleteBookById(book_id);
        return "Book deleted successfully!!";
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody @NotNull BookToSaveRequest bookToSaveRequest){
        return bookService.saveBook(bookToSaveRequest);
    }

    @GetMapping("/books/{author}")
    public List<BooksByAuthorNameWithPriceResponse> fetchBooksByAuthorNameWithPrice(@PathVariable("author") String name_author)
    {
         return bookService.fetchBooksByAuthorNameWithPrice(name_author);
    }
}
