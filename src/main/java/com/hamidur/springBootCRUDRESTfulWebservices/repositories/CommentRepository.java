package com.hamidur.springBootCRUDRESTfulWebservices.repositories;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {}
