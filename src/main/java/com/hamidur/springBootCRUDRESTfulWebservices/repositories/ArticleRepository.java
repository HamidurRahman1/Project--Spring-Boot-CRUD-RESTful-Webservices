package com.hamidur.springBootCRUDRESTfulWebservices.repositories;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {}
