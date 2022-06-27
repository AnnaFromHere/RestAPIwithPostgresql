package com.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_author_id_seq",
            sequenceName = "author_author_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_author_id_seq"
    )
    private Long author_id;

    private String name_author;

    @JsonIgnore
    @OneToMany(mappedBy = "author", orphanRemoval=true)
    private List<Book> books;
}
