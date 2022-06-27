package com.restapi.repository;

import com.restapi.dto.BooksByAuthorNameWithPriceResponse;
import com.restapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT new com.restapi.dto.BooksByAuthorNameWithPriceResponse(b.title, b.price) FROM Book b JOIN b.author a where a.name_author = ?1 ORDER BY PRICE")
    List<BooksByAuthorNameWithPriceResponse> getBookByAuthorNameWithPrice(String name_author);
}