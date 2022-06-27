package com.restapi.service;

import com.restapi.dto.BooksByAuthorNameWithPriceResponse;
import com.restapi.dto.BookToSaveRequest;
import com.restapi.entity.Book;
import com.restapi.error.BookNotFoundException;

import java.util.List;

public interface BookService {
    public List<Book> fetchBookList();

    public Book fetchBookById(Long book_id) throws BookNotFoundException;

    public void deleteBookById(Long book_id);

    public List<BooksByAuthorNameWithPriceResponse> fetchBooksByAuthorNameWithPrice(String name_author);

    public Book saveBook(BookToSaveRequest bookToSaveRequest);
}
