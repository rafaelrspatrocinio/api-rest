package com.br.apirest.servises;

import com.br.apirest.domain.User;
import com.br.apirest.exception.ObjetcNotFoundException;
import com.br.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjetcNotFoundException("Objeto não encontrado"));
    }
}
