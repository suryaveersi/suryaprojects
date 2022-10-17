package com.starwar.api.service;


import com.starwar.api.dao.PlanetRepo;
import com.starwar.api.dto.FilmResponse;
import com.starwar.api.dto.PlanetResponse;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.model.FetchData;
import com.starwar.api.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService implements FetchData {

    @Autowired
    PlanetRepo planetRepo;

    @Override
    public StarWarResponse getDataById(Integer id)
    {
        Planet databyid = planetRepo.findById(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));

        StarWarResponse planetResponse = PlanetResponse.builder()
                .url(databyid.getUrl())
                .name(databyid.getName())
                .films(databyid.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .peoples(databyid.getPeoples().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .build();

        return planetResponse;
    }

    public List<StarWarResponse> getPlanetAllData()
    {
        List<StarWarResponse> planetResponseList = new ArrayList<>();
        List<Planet> datas = planetRepo.findAll();
        for(Planet data : datas) {

            StarWarResponse planetResponse  =   PlanetResponse.builder()
                    .url(data.getUrl())
                    .name(data.getName())
                    .films(data.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                    .peoples(data.getPeoples().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                    .build();
          planetResponseList.add(planetResponse);
        }

        return planetResponseList;
    }

    @Override
    public StarWarResponse getDataByName(String name)
    {
        Planet databyname = planetRepo.findByName(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));

        StarWarResponse planetResponse = PlanetResponse.builder()
                .url(databyname.getUrl())
                .name(databyname.getName())
                .films(databyname.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .peoples(databyname.getPeoples().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .build();

        return planetResponse;
    }

}
