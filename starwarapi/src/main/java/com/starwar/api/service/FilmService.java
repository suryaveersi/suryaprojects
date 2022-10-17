package com.starwar.api.service;


import com.starwar.api.dao.FilmRepo;
import com.starwar.api.dto.FilmResponse;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.dto.FetchData;
import com.starwar.api.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService implements FetchData {

    @Autowired
    FilmRepo filmRepo;


    public List<StarWarResponse> getAllData() {
        List<Film> filmList = filmRepo.findAll();

        List<StarWarResponse> filmResponseList = new ArrayList<>();

        for(Film film : filmList) {

            StarWarResponse filmResponse = FilmResponse.builder()
                    .title(film.getTitle())
                    .episode_id(film.getEpisode_id())
                    .url(film.getUrl())
                    .planets(film.getPlanets().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                    .peoples(film.getPeoples().stream().map(i->i.getUrl()).collect(Collectors.toList()))
                    .build();
            filmResponseList.add(filmResponse);
        }

        return filmResponseList;
    }


    @Override
    public StarWarResponse getDataByName(String name)
    {
        Film dataByName = filmRepo.findByTitle(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));
        StarWarResponse response = FilmResponse.builder()
                 .title(dataByName.getTitle())
                 .episode_id(dataByName.getEpisode_id())
                 .url(dataByName.getUrl())
                 .planets(dataByName.getPlanets().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                 .peoples(dataByName.getPeoples().stream().map(i->i.getUrl()).collect(Collectors.toList()))
                 .build();
        return response;
    }

    @Override
    public StarWarResponse getDataById(Integer id) {
        Film dataById = filmRepo.findByFilmid(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));

        StarWarResponse filmResponse = FilmResponse.builder()
                .title(dataById.getTitle())
                .episode_id(dataById.getEpisode_id())
                .url(dataById.getUrl())
                .planets(dataById.getPlanets().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .peoples(dataById.getPeoples().stream().map(i->i.getUrl()).collect(Collectors.toList()))
                .build();
        return filmResponse;
    }
}
