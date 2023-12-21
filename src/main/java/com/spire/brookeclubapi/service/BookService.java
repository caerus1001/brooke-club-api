package com.spire.brookeclubapi.service;

import com.spire.brookeclubapi.client.NyTimesClient;
import com.spire.brookeclubapi.model.*;
import com.spire.brookeclubapi.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookService {
    private NyTimesClient nyTimesClient;

    public BookService(NyTimesClient nyTimesClient) {
        this.nyTimesClient = nyTimesClient;
    }

    public Mono<List<BookList>> getTopBooks(String publishedDate) {
        return this.nyTimesClient.getTopBooks(publishedDate);
    }
}
