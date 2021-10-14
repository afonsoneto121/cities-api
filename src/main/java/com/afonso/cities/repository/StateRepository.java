package com.afonso.cities.repository;

import com.afonso.cities.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findAllByUfContaining(String uf);

    List<State> findAllByNameContaining(String name);
}
