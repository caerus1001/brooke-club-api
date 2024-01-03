package com.spire.brookeclubapi.client;

import com.spire.brookeclubapi.model.BookDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GoogleBooksClient {

    @Value("${google-books-api-base-url}")
    private String googleBooksApiUrl;

    @Value("${google-books-search-isbn}")
    private String googleBooksSearchIsbn;

    @Value("${google-books-api-key}")
    private String apiKey;

    public GoogleBooksClient(WebClient.Builder webClientBuilder) {

    }

    public Mono<BookDetails> getBookDetails(String isbn) {
        String uri = String.format(googleBooksSearchIsbn, isbn, apiKey);
        return WebClient.builder().baseUrl(googleBooksApiUrl).build()
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BookDetails.class);
    }
}
