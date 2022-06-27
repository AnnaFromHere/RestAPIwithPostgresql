package com.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    @Id
    @SequenceGenerator(
            name = "genre_genre_id_seq",
            sequenceName = "genre_genre_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_genre_id_seq"
    )
    private Long genre_id;
    private String name_genre;

    @JsonIgnore
    @OneToMany(mappedBy = "genre", orphanRemoval = true)
    private List<Book> books;
}
