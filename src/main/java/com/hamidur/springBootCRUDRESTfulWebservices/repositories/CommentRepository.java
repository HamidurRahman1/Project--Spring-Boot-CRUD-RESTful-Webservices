package com.hamidur.springBootCRUDRESTfulWebservices.repositories;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {}
