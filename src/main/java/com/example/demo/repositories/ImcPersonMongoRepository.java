package com.example.demo.repositories;

import java.util.UUID;

import com.example.demo.models.mongo.Person;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImcPersonMongoRepository extends MongoRepository<Person, UUID> {
    
}
