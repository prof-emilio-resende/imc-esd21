package com.example.demo.repositories;

import com.example.demo.models.jpa.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImcPersonJpaRepository extends JpaRepository<Person, Long> {}
