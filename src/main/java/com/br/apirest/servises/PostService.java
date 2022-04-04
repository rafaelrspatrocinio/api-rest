package com.br.apirest.servises;

import com.br.apirest.domain.Post;
import com.br.apirest.exception.ObjetcNotFoundException;
import com.br.apirest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjetcNotFoundException("Objeto não encontrado"));
    }
}
