package com.starwar.api.dto;

import com.starwar.api.dto.StarWarResponse;

import java.util.List;

public interface FetchData<T extends StarWarResponse> {

    T getDataById(Integer id);
    T getDataByName(String name);
    List<T> getAllData();



}
