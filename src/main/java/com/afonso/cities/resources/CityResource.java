package com.afonso.cities.resources;

import com.afonso.cities.entities.City;
import com.afonso.cities.repository.CityRepository;
import com.afonso.cities.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/cities")
@RequiredArgsConstructor
public class CityResource {
    private final CityService cityService;

    @GetMapping
    public Page<City> findAll(Pageable pageable) {
        return cityService.findAll(pageable);
    }

    @GetMapping("/distance")
    public Double distance(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        return cityService.distanceInMeters(city1,city2);
    }
    @GetMapping("query")
    public Page<City> findByName(@RequestParam(name = "name") String name, Pageable pageable) {
        return cityService.findByName(name,pageable);
    }
}
