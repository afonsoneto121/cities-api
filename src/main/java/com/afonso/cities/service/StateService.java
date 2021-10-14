package com.afonso.cities.service;

import com.afonso.cities.entities.State;
import com.afonso.cities.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository repository;

    public List<State> findAll() {
        return repository.findAll();
    }
}
