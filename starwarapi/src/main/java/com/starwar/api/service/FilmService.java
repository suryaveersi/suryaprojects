package com.starwar.api.service;


import com.starwar.api.dao.FilmRepo;
import com.starwar.api.dto.FilmResponse;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.model.FetchData;
import com.starwar.api.model.Film;
import com.starwar.api.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService implements FetchData {

    @Autowired
    FilmRepo filmRepo;


    public List<Film> getAllData()
    {
        List<Film> data = filmRepo.findAll();
        List<FilmResponse> response = FilmResponse.builder()
                .

        return data;
    }


    @Override
    public StarWarResponse getDataByName(String name)
    {
        Film databyname = filmRepo.findByTitle(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));
         FilmResponse response = FilmResponse.builder()
                 .title(databyname.getTitle())
                 .episode_id(databyname.getEpisode_id())
                 .url(databyname.getUrl())
                 .planets(databyname.getPlanets().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                 .peoples(databyname.getPeoples().stream().map(i->i.getUrl()).collect(Collectors.toList()))
                 .build();
        return response;
    }

    @Override
    public StarWarResponse getDataById(Integer id) {
        Film databyid = filmRepo.findByFilmid(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));

        FilmResponse filmResponse = FilmResponse.builder()
                .title(databyid.getTitle())
                .episode_id(databyid.getEpisode_id())
                .url(databyid.getUrl())
                .planets(databyid.getPlanets().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .peoples(databyid.getPeoples().stream().map(i->i.getUrl()).collect(Collectors.toList()))
                .build();
        return filmResponse;
    }
}
