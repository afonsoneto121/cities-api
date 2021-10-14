package com.afonso.cities.repository;

import com.afonso.cities.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double calculedistance(final Double lat,final Double lon,final Double lat1,final Double lon1);

    Page<City> findAllByUf(int uf, Pageable pageable);

    Page<City> findAllByNameContaining(String name, Pageable pageable);
}
