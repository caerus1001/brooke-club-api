package com.spire.brookeclubapi.service;

import com.spire.brookeclubapi.model.CreateShelfDto;
import com.spire.brookeclubapi.model.Shelf;
import com.spire.brookeclubapi.repository.IShelfRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ShelfService {
    private final IShelfRepository shelfRepository;
    private final ModelMapper modelMapper;

    public ShelfService(IShelfRepository shelfRepository, ModelMapper modelMapper) {
        this.shelfRepository = shelfRepository;
        this.modelMapper = modelMapper;
    }

    public Mono<Shelf> createBookshelf(CreateShelfDto request) {
        Shelf shelf  = modelMapper.map(request, Shelf.class);
        return shelfRepository.save(shelf);
    }
}
