package com.spire.brookeclubapi.repository;

import com.spire.brookeclubapi.model.Shelf;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShelfRepository extends ReactiveMongoRepository<Shelf, String> {
}
