package com.spire.brookeclubapi.controller;

import com.spire.brookeclubapi.model.*;
import com.spire.brookeclubapi.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Gets the top 5 from all the Best Sellers List.
     *
     * @return List of Books.
     */
    @GetMapping("/top-books")
    public Mono<List<BookList>> getTopBooks(@RequestParam(required = false) String publishedDate) {
        if (publishedDate == null || publishedDate.isEmpty()) {
            publishedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return this.bookService.getTopBooks(publishedDate);
    }

    @GetMapping(value = "/book-details")
    public Mono<BookDetails> getBookDetails(String isbn) {
        return this.bookService.getBookDetails(isbn);
    }
}
