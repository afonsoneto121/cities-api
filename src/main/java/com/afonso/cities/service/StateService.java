package com.afonso.cities.service;

import com.afonso.cities.entities.City;
import com.afonso.cities.entities.State;
import com.afonso.cities.exception.BadRequestException;
import com.afonso.cities.repository.CityRepository;
import com.afonso.cities.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public Page<State> findAll(Pageable pageable) {
        return stateRepository.findAll(pageable);
    }

    public List<State> findByQuery(String name, String uf) throws BadRequestException {
        if(name == null && uf == null) {
            throw new BadRequestException();
        }
        List<State> states = name == null ? stateRepository.findAllByUfContaining(uf) : stateRepository.findAllByNameContaining(name);
        return states;
    }

    public Page<City> findAllByUf(int id, Pageable pageable) {
        return cityRepository.findAllByUf(id, pageable);
    }
}