package com.starwar.api.service;

import com.starwar.api.dao.PeopleRepo;
import com.starwar.api.dto.PeopleResponse;
import com.starwar.api.dto.PlanetResponse;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.model.FetchData;
import com.starwar.api.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleService implements FetchData {


    @Autowired
    PeopleRepo peopleRepo;

    @Override
    public StarWarResponse getDataById(Integer id)
    {
        People databyid = peopleRepo.findByPeopleid(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));
        PeopleResponse peopleResponse = PeopleResponse.builder()
                .url(databyid.getUrl())
                .birth_year(databyid.getBirth_year())
                .gender(databyid.getGender())
                .name(databyid.getName())
                .Films(databyid.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .build();
        return  peopleResponse;
    }

    public List<People> getPeopleAllData()
    {
        List<People> data = peopleRepo.findAll();
        System.out.println("hi");
        return data;
    }

    @Override
    public StarWarResponse getDataByName(String name)
    {
        People databyname = peopleRepo.findByName(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));
        PeopleResponse peopleResponse = PeopleResponse.builder()
                .url(databyname.getUrl())
                .birth_year(databyname.getBirth_year())
                .gender(databyname.getGender())
                .name(databyname.getName())
                .Films(databyname.getFilms().stream().map(i-> i.getUrl()).collect(Collectors.toList()))
                .build();
        return peopleResponse;
    }


}
