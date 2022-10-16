package com.starwar.api.dto;

import com.starwar.api.model.Film;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PlanetResponse implements StarWarResponse{

    String name;
    String url ;
    List<String> films;
    List<String> peoples;
}
