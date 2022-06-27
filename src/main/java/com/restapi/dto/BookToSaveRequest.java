package com.restapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookToSaveRequest {

    private String title;
    private Double price;
    private Integer amount;
    private String name_genre;
    private String name_author;
    }
