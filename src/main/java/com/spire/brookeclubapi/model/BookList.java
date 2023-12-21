package com.spire.brookeclubapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookList {
    @JsonAlias("list_name")
    private String listName;
    private List<TopBook> books;
}
