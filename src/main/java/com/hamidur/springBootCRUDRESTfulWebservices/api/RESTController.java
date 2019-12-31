package com.hamidur.springBootCRUDRESTfulWebservices.api;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Article;
import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Comment;
import com.hamidur.springBootCRUDRESTfulWebservices.services.AuthorService;
import com.hamidur.springBootCRUDRESTfulWebservices.services.ArticleService;

import com.hamidur.springBootCRUDRESTfulWebservices.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @Autowired
    private CommentService commentService;

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

    @GetMapping(value = "/getArticle/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getArticleById(@PathVariable Long articleId)
    {
        Article article = articleService.getArticleById(articleId);
        return article != null ? new ResponseEntity<>(article, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/author/{authorId}/insertArticle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPost(@RequestBody Article incomingArticle, @PathVariable Long authorId)
    {
        Author retrievedAuthor = authorService.getAuthorById(authorId);
        retrievedAuthor.getArticles().add(incomingArticle);
        incomingArticle.setAuthor(retrievedAuthor);
        Article retrievedArticle = articleService.insertArticle(incomingArticle);
        authorService.updateAuthor(retrievedAuthor);
        return retrievedArticle.getArticleId() != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/getComment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId)
    {
        Comment comment = commentService.getCommentById(commentId);
        return comment != null ? new ResponseEntity<>(comment, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/article/{articleId}/insertComment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertComment(@RequestBody Comment incomingComment, @PathVariable Long articleId)
    {
        Article retrievedArticle = articleService.getArticleById(articleId);
        Comment retrievedComment = commentService.insertComment(incomingComment);
        retrievedArticle.getComments().add(incomingComment);
        articleService.updateArticle(retrievedArticle);
        return retrievedComment.getCommentId() != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
