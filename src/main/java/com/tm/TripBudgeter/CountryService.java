package com.tm.TripBudgeter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository repository;

    public Iterable<Country> all() {
        return repository.findAll();
    }
    public Optional<Country> findById(Long id) {
        return  repository.findById(id);
    }
}
