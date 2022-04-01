package com.br.apirest.dto;

import com.br.apirest.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private String id;
    private String name;
    private String email;

    public UserDTO(User obj){

        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();

    }
}
