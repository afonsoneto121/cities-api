package com.afonso.cities.resources;

import com.afonso.cities.entities.State;
import com.afonso.cities.repository.StateRepository;
import com.afonso.cities.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/states")
@RequiredArgsConstructor
public class StateResource {
    private final StateService service;

    @GetMapping
    public List<State> findAll() {
        return service.findAll();
    }
}
