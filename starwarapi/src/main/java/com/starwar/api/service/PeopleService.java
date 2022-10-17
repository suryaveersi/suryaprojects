package com.starwar.api.service;

import com.starwar.api.dao.PeopleRepo;
import com.starwar.api.dto.PeopleResponse;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.dto.FetchData;
import com.starwar.api.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleService implements FetchData {


    @Autowired
    PeopleRepo peopleRepo;

    @Override
    public StarWarResponse getDataById(Integer id)
    {
        People dataById = peopleRepo.findByPeopleid(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));
        StarWarResponse peopleResponse = PeopleResponse.builder()
                .url(dataById.getUrl())
                .birth_year(dataById.getBirth_year())
                .gender(dataById.getGender())
                .name(dataById.getName())
                .Films(dataById.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .build();
        return  peopleResponse;
    }

    public List<StarWarResponse> getAllData()
    {
        List<People> peopleList = peopleRepo.findAll();


        List<StarWarResponse> peopleResponseList = new ArrayList<>();

        for(People people : peopleList) {

            StarWarResponse peopleResponse = PeopleResponse.builder()
                    .url(people.getUrl())
                    .birth_year(people.getBirth_year())
                    .gender(people.getGender())
                    .name(people.getName())
                    .Films(people.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                    .build();
            peopleResponseList.add(peopleResponse);
        }

        return peopleResponseList;
    }

    @Override
    public StarWarResponse getDataByName(String name)
    {
        People dataByName = peopleRepo.findByName(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));
        StarWarResponse peopleResponse = PeopleResponse.builder()
                .url(dataByName.getUrl())
                .birth_year(dataByName.getBirth_year())
                .gender(dataByName.getGender())
                .name(dataByName.getName())
                .Films(dataByName.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .build();
        return peopleResponse;
    }


}
