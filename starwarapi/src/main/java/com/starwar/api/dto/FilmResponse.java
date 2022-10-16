package com.starwar.api.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilmResponse {

    String  title ;
    Integer episode_id ;

    String url;
}
