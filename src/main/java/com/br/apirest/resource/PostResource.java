package com.br.apirest.resource;

import com.br.apirest.domain.Post;
import com.br.apirest.domain.User;
import com.br.apirest.dto.UserDTO;
import com.br.apirest.resource.utils.URL;
import com.br.apirest.servises.PostService;
import com.br.apirest.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

        text = URL.decodeParam(text);

        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/buscatodos")
    public ResponseEntity<List<Post>> buscatodos(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "text", defaultValue = "") String minDate,
            @RequestParam(value = "text", defaultValue = "") String maxDate) {

        text = URL.decodeParam(text);

        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.consulta(text, min, max);

        return ResponseEntity.ok().body(list);
    }
}
