package com.restapi.service;

import com.restapi.dto.BooksByAuthorNameWithPriceResponse;
import com.restapi.dto.BookToSaveRequest;
import com.restapi.entity.Author;
import com.restapi.entity.Book;
import com.restapi.entity.Genre;
import com.restapi.error.BookNotFoundException;
import com.restapi.repository.AuthorRepository;
import com.restapi.repository.BookRepository;
import com.restapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    public BookServiceImpl() {
    }
    @Override
    public List<Book> fetchBookList() {
        return bookRepository.findAll();
    }
    @Override
    public Book fetchBookById(Long book_id) throws BookNotFoundException {
        Optional<Book> book =
                bookRepository.findById(book_id);

        if(!book.isPresent()) {
            throw new BookNotFoundException("Book Not Available");
        }

        return  book.get();
    }
    @Override
    public void deleteBookById(Long book_id) {
        bookRepository.deleteById(book_id);

        }
    @Override
    public List<BooksByAuthorNameWithPriceResponse> fetchBooksByAuthorNameWithPrice(String name_author) {
        return bookRepository.getBookByAuthorNameWithPrice(name_author);
    }

    @Override
    public Book saveBook(BookToSaveRequest bookToSaveRequest)
    {
        Author author = new Author();
        Genre genre = new Genre();
        Book book = new Book();

        Optional<Author> authorOptional =
                authorRepository.getAuthorByName_author(bookToSaveRequest.getName_author());

        if(authorOptional.isPresent()) {
            author = authorOptional.get();
        }
        else{
            author.setName_author(bookToSaveRequest.getName_author());
            authorRepository.save(author);
        }

        Optional<Genre> genreOptional =
                genreRepository.getGenreByName_genre(bookToSaveRequest.getName_genre());

        if(genreOptional.isPresent()) {
            genre = genreOptional.get();
        }
        else {
            genre.setName_genre(bookToSaveRequest.getName_genre());
            genreRepository.save(genre);
        }

        book.setTitle(bookToSaveRequest.getTitle());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAmount(bookToSaveRequest.getAmount());
        book.setPrice(bookToSaveRequest.getPrice());

        return bookRepository.save(book);
    }
}
