package com.spire.brookeclubapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopBook {
    private String author;
    @JsonAlias("created_date")
    private String description;
    private String price;
    @JsonAlias("primary_isbn13")
    private String isbn;
    private int rank;
    private String title;
}
