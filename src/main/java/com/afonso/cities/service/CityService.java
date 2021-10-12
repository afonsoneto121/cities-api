package com.afonso.cities.service;

import com.afonso.cities.entities.City;
import com.afonso.cities.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public Double distanceInMeters(Long city1, Long city2) {
        List<City> cities = repository.findAllById(Arrays.asList(city1, city2));
        Double lat1 = cities.get(0).getLat();
        Double lon1 = cities.get(0).getLon();

        Double lat2 = cities.get(1).getLat();
        Double lon2 = cities.get(1).getLon();

        return repository.calculedistance(lat1,lon1, lat2,lon2);
    }
}
