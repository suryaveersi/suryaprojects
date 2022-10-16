package com.starwar.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlanetResponse {

    String name;
    String url ;

}
