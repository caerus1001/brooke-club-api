package com.spire.brookeclubapi.client;

import com.spire.brookeclubapi.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class NyTimesClient {

    @Value("${ny-times-book-api-base-url}")
    private String nyTimesBookApiUrl;

    @Value("${ny-times-lists-overview}")
    private String nyTimesListsOverview;

    @Value("${ny-times-book-api-key}")
    private String apiKey;

    private WebClient webClient;

    public NyTimesClient(WebClient.Builder webClientBuilder) {
        //this.webClient = webClientBuilder.baseUrl(nyTimesBookApiUrl).build();
    }

    public Mono<List<BookList>> getTopBooks(String publishedDate) {
        String uri = String.format(nyTimesListsOverview, publishedDate, apiKey);
        return WebClient.builder().baseUrl(nyTimesBookApiUrl).build()
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Response.class))
                .flatMapIterable(clientResponse -> clientResponse.getResults().getLists())
                .collectList();
    }
}
