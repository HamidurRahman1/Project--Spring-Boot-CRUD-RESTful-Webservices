package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Post;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService
{
    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Long postId)
    {
        return postRepository.findById(postId).get();
    }

    public void insertPost(Post post)
    {
        Post post1 = new Post();
        post1.setTitle("title1");
        post1.setBody("body1");
        post1.setPublishedDate(LocalDate.of(2019, 12, 30));
        postRepository.save(post1);
    }
}
