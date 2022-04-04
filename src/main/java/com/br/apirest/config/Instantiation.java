package com.br.apirest.config;

import com.br.apirest.domain.Post;
import com.br.apirest.domain.User;
import com.br.apirest.dto.AuthorDTO;
import com.br.apirest.dto.ComentDTO;
import com.br.apirest.repository.PostRepository;
import com.br.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("04/04/2022"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("03/04/2022"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        ComentDTO coment1 = new ComentDTO("Boa viagem mano!",sdf.parse("04/04/2022"), new AuthorDTO(alex));
        ComentDTO coment2 = new ComentDTO("Aproveite!",sdf.parse("04/04/2022"), new AuthorDTO(bob));
        ComentDTO coment3 = new ComentDTO("Tenha um ótimo dia!",sdf.parse("03/04/2022"), new AuthorDTO(alex));

        post1.getComents().addAll(Arrays.asList(coment1, coment2));
        post2.getComents().addAll(Arrays.asList(coment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);
    }
}
