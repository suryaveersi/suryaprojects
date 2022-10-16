package com.starwar.api.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FilmResponse implements StarWarResponse {

    String  title ;
    Integer episode_id ;
    String url;
    List<String> planets;
    List<String> peoples;
}
