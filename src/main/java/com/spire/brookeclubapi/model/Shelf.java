package com.spire.brookeclubapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shelf {
    @Id
    private String id;
    private String name;
    private List<BookDetails> books;
}
