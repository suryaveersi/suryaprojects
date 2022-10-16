package com.starwar.api.service;


import com.starwar.api.dao.PlanetRepo;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    PlanetRepo planetRepo;
    

    public Planet getPlanetDataById(Integer id)
    {
        Planet databyid = planetRepo.findById(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));
        return databyid;
    }

    public List<Planet> getPlanetAllData()
    {
        List<Planet> data = planetRepo.findAll();
        System.out.println("hi");
        return data;
    }


    public Planet getPlanetDataByName(String name)
    {
        Planet databyname = planetRepo.findByName(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));

        return databyname;
    }

}
