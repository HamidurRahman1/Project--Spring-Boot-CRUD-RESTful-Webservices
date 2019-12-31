package com.hamidur.springBootCRUDRESTfulWebservices.api;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Post;
import com.hamidur.springBootCRUDRESTfulWebservices.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RESTController
{
    @Autowired
    private PostService postService;

    @GetMapping(value = "/getPost/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable Long postId)
    {
        Post post = postService.getPostById(postId);
        if(post == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping(value = "/insertPost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPost(@RequestBody Post post)
    {
        postService.insertPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
