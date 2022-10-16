package com.starwar.api.dao;

import com.starwar.api.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepo extends JpaRepository<Planet,Integer> {

    public Optional<Planet> findByPlanetid(Integer id);
    public Optional<Planet> findByName(String name);
}
