package com.starwar.api.service;


import com.starwar.api.dao.FilmRepo;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.model.Film;
import com.starwar.api.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService  {

    @Autowired
    FilmRepo filmRepo;


    public List<Film> getAllData()
    {
        List<Film> data = filmRepo.findAll();
        System.out.println("hi");
        return data;
    }



    public Film getFilmDataByName(String name)
    {
        Film databyname = filmRepo.findByTitle(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));

        return databyname;
    }


    public Film geFilmDataById(Integer id) {
        Film databyid = filmRepo.findByFilmid(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));
        return databyid;
    }
}
