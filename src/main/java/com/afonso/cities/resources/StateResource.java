package com.afonso.cities.resources;

import com.afonso.cities.entities.State;
import com.afonso.cities.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/states")
@RequiredArgsConstructor
public class StateResource {
    private final StateRepository stateRepository;

    @GetMapping
    public List<State> findAll() {
        return stateRepository.findAll();
    }
}
