package com.starwar.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class StarWarItemIdNotFoundException extends  RuntimeException {

    Integer id;
    String message;


}
