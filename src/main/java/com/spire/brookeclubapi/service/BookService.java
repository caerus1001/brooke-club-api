package com.spire.brookeclubapi.service;

import com.spire.brookeclubapi.client.GoogleBooksClient;
import com.spire.brookeclubapi.client.NyTimesClient;
import com.spire.brookeclubapi.model.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookService {
    private final NyTimesClient nyTimesClient;
    private final GoogleBooksClient googleBooksClient;

    public BookService(NyTimesClient nyTimesClient, GoogleBooksClient googleBooksClient) {
        this.nyTimesClient = nyTimesClient;
        this.googleBooksClient = googleBooksClient;
    }

    public Mono<List<BookList>> getTopBooks(String publishedDate) {
        return this.nyTimesClient.getTopBooks(publishedDate);
    }

    public Mono<BookDetails> getBookDetails(String isbn) {
        return this.googleBooksClient.getBookDetails(isbn);
    }
}
