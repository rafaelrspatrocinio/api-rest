package com.br.apirest.exception;

public class ObjetcNotFoundException extends RuntimeException{
            private static final long serialVersionUID = 1l;

    public ObjetcNotFoundException(String msg){
        super(msg);
    }
}
