package com.spire.brookeclubapi.controller;

import com.spire.brookeclubapi.model.CreateShelfDto;
import com.spire.brookeclubapi.model.Shelf;
import com.spire.brookeclubapi.service.ShelfService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shelves")
public class ShelfController {
    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @PostMapping("")
    public Mono<Shelf> createShelf(@RequestBody @Valid CreateShelfDto request) {
        return shelfService.createBookshelf(request);
    }
}
