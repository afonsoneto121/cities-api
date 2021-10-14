package com.afonso.cities.repository;

import com.afonso.cities.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Page<Country> findAllByNameOrPortugueseName(String name, String name1, Pageable pageable);
}
