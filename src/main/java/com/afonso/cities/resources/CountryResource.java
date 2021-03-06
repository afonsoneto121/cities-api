package com.afonso.cities.resources;

import com.afonso.cities.entities.Country;
import com.afonso.cities.exception.NotFoundException;
import com.afonso.cities.repository.CountryRepository;
import com.afonso.cities.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/countries")
@RequiredArgsConstructor
public class CountryResource {


    private final CountryService service;
    @GetMapping
    public Page<Country> countries(Pageable page) {
        return service.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping("/query")
    public Page<Country> findByName(@RequestParam(name = "name") String name, Pageable pageable) {
        return service.findByName(name, pageable);
    }
}
