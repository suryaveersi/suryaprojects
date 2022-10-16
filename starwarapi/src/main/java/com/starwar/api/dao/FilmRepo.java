package com.starwar.api.dao;

import com.starwar.api.model.Film;
import com.starwar.api.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepo extends JpaRepository<Film,Integer> {

    public Optional<Film> findByFilmid(Integer id);
    public Optional<Film> findByTitle(String title);
}
