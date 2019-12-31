package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Article;
import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Comment;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService
{
    @Autowired
    private ArticleRepository articleRepository;

    public Article getArticleById(Long articleId)
    {
        Optional<Article> article = articleRepository.findById(articleId);
        return article.isPresent() ? article.get() : null;
    }

    public Article insertArticle(Article article)
    {
        return articleRepository.save(article);
    }

    public void updateArticle(Article retrievedArticle)
    {
        articleRepository.save(retrievedArticle);
    }
}
