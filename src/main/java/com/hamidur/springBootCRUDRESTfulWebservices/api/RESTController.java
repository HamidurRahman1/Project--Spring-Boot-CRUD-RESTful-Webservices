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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(value = "/author/{authorId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId)
    {
        Author author = authorService.getAuthorById(authorId);
        return author != null ? new ResponseEntity<>(author, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAllAuthors()
    {
        List<Author> authors = authorService.getAuthors();
        if(authors == null || authors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping(value = "/author/{authorId}/articles")
    public ResponseEntity<List<Article>> getAllArticlesByAuthor(@PathVariable Long authorId)
    {
        List<Article> articles = authorService.getAuthorById(authorId).getArticles();
        if(articles == null || articles.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @PutMapping(value = "/author/update")
    public ResponseEntity<Author> updateAuthorById(@RequestBody Author newAuthor)
    {
        if(newAuthor == null || newAuthor.getAuthorId() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(authorService.updateAuthor(newAuthor), HttpStatus.OK);
    }

    @PostMapping(value = "/insertAuthor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertAuthor(@RequestBody Author author)
    {
        Author author1 = authorService.insertAuthor(author);
        return author1.getAuthorId() != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/article/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
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
        return retrievedArticle.getArticleId() != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @DeleteMapping(value = "/delete/article/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId)
    {
        Article article = articleService.getArticleById(articleId);
        System.out.println(article + " " + article.getAuthor().getFirstName());
        Author author = article.getAuthor();
        author.getArticles().remove(article);
        article.setAuthor(null);
        authorService.updateAuthor(author);
//        articleService.deleteArticle(articleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
