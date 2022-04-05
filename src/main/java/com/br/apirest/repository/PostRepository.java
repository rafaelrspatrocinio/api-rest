package com.br.apirest.repository;

import com.br.apirest.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> buscaTitulo(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);


    @Query("{ $and: [ { date: { $gte: ?1 } }, { { date: { $lte: ?2 } } }, { $or: [ { 'title' : { $regex: ?0, $options: 'i' } }, { 'body' : { $regex: ?0, $options: 'i' } }, { 'coments.text' : { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> buscaTodos(String text, Date minDate, Date maxDate);
}
