package com.hamidur.springBootCRUDRESTfulWebservices.repositories;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
