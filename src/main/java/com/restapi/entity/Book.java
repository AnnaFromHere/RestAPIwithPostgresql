package com.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
//uniqueConstraints = { @UniqueConstraint(columnNames = { "title", "author_id", "genre_id", "price", "am" }) })
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_book_id_seq",
            sequenceName = "book_book_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_book_id_seq"
    )
    private Long book_id;
    private String title;
    private Double price;
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST }
    )
    @JoinColumn(
            name = "genre_id",
            referencedColumnName = "genre_id"
    )
    private Genre genre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST }
    )
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "author_id"
    )
    private Author author;
}
