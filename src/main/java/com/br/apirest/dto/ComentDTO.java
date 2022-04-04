package com.br.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private String text;
    private Date date;
    private AuthorDTO author;

}
