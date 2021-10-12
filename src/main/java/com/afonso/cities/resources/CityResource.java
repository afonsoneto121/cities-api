package com.afonso.cities.resources;

import com.afonso.cities.entities.City;
import com.afonso.cities.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/cities")
@RequiredArgsConstructor
public class CityResource {
    private final CityRepository cityRepository;

    @GetMapping
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
