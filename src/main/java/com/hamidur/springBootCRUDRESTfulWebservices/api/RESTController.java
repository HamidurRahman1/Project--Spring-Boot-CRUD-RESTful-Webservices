package com.hamidur.springBootCRUDRESTfulWebservices.api;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Article;
import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import com.hamidur.springBootCRUDRESTfulWebservices.services.AuthorService;
import com.hamidur.springBootCRUDRESTfulWebservices.services.ArticleService;

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
    private ArticleService articleService;
    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/getAuthor/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId)
    {
        Author author = authorService.getAuthorById(authorId);
        return author != null ? new ResponseEntity<>(author, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/insertAuthor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertAuthor(@RequestBody Author author)
    {
        Author author1 = authorService.insertAuthor(author);
        return author1.getAuthorId() != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/getPost/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getPostById(@PathVariable Long postId)
    {
        Article article = articleService.getArticleById(postId);
        return article != null ? new ResponseEntity<>(article, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/insertPost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPost(@RequestBody Article article)
    {
        Article article1 = articleService.insertArticle(article);
        return article1.getArticleId() != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
