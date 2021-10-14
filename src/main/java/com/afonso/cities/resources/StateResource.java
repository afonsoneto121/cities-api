package com.afonso.cities.resources;

import com.afonso.cities.entities.City;
import com.afonso.cities.entities.State;
import com.afonso.cities.exception.BadRequestException;
import com.afonso.cities.repository.StateRepository;
import com.afonso.cities.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/states")
@RequiredArgsConstructor
public class StateResource {
    private final StateService service;

    @GetMapping
    public Page<State> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/query")
    public List<State> findByName(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "uf", required = false) String uf) throws BadRequestException {
        return service.findByQuery(name, uf);
    }
    @GetMapping("/cities/{id}")
    public Page<City> findAllCities(@PathVariable int id, Pageable pageable) {
        return service.findAllByUf(id,pageable);
    }
}
