package com.br.apirest.servises;

import com.br.apirest.domain.Post;
import com.br.apirest.exception.ObjetcNotFoundException;
import com.br.apirest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjetcNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){

        return repository.buscaTitulo(text);
    }
}
