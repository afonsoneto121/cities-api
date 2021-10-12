package com.afonso.cities.resources;

import com.afonso.cities.entities.Country;
import com.afonso.cities.exception.NotFoundException;
import com.afonso.cities.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/countries")
@RequiredArgsConstructor
public class CountryResource {

    private final CountryRepository countryRepository;

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok().body(countryRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Country not found")));
    }
}
