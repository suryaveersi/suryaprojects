package com.starwar.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PeopleResponse implements StarWarResponse {

    String name ;
    String birth_year;
    String gender ;
    String url ;
    List<String> Films;
}
