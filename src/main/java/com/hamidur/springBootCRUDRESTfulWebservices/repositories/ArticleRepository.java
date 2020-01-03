package com.hamidur.springBootCRUDRESTfulWebservices.repositories;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>
{
    List<Article> findAll();
}
