package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Article;
import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService
{
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles()
    {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long articleId)
    {
        Optional<Article> article = articleRepository.findById(articleId);
        return article.isPresent() ? article.get() : null;
    }

    public Article insertArticle(Article article)
    {
        return articleRepository.save(article);
    }

    public Article updateArticle(Article retrievedArticle)
    {
        Article article = articleRepository.findById(retrievedArticle.getArticleId()).get();
        article.setAuthor(article.getAuthor());

        article.setArticleId(retrievedArticle.getArticleId());
        article.setTitle(retrievedArticle.getTitle());
        article.setBody(retrievedArticle.getBody());
        article.setPublishedDate(retrievedArticle.getPublishedDate());
        article.setComments(retrievedArticle.getComments());

        return articleRepository.save(article);
    }

    public void deleteArticle(Long articleId)
    {
        articleRepository.deleteById(articleId);
    }
}
