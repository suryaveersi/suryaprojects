package com.starwar.api.service;

import com.starwar.api.dao.PeopleRepo;
import com.starwar.api.exception.StarWarItemIdNotFoundException;
import com.starwar.api.exception.StarWarItemNameNotFoundException;
import com.starwar.api.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService  {


    @Autowired
    PeopleRepo peopleRepo;


    public People gePeopleDataById(Integer id)
    {
        People databyid = peopleRepo.findByPeopleid(id).orElseThrow(()-> new StarWarItemIdNotFoundException(id,"Planet id not found in database"));
        return databyid;
    }

    public List<People> getPeopleAllData()
    {
        List<People> data = peopleRepo.findAll();
        System.out.println("hi");
        return data;
    }


    public People getPeopleDataByName(String name)
    {
        People databyname = peopleRepo.findByName(name).orElseThrow(()-> new StarWarItemNameNotFoundException(name,"Film name not found in database"));

        return databyname;
    }


}
