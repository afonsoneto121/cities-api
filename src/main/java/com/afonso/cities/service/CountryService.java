package com.afonso.cities.service;

import com.afonso.cities.entities.Country;
import com.afonso.cities.exception.NotFoundException;
import com.afonso.cities.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;


    public Page<Country> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Country findById(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow( () -> new NotFoundException("Country not found"));
    }
}
