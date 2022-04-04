package com.br.apirest.dto;

import com.br.apirest.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private String id;
    private String name;

    public AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }
}
