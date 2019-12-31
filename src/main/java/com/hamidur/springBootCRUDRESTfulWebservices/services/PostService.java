package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Post;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PostService
{
    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Long postId)
    {
        Optional<Post> post = postRepository.findById(postId);
        return post.isPresent() ? post.get() : null;
    }

    public void insertPost(Post post)
    {
        postRepository.save(post);
    }
}
