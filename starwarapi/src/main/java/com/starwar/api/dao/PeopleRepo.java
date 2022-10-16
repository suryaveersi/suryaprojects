package com.starwar.api.dao;

import com.starwar.api.model.People;
import com.starwar.api.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepo extends JpaRepository<People,Integer> {

    public Optional<People> findByPeopleid(Integer id);
    public Optional<People> findByName(String name);
}
