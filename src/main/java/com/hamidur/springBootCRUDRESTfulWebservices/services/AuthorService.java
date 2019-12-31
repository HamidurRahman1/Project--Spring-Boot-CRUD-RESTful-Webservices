package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthorById(Long authorId)
    {
        Optional<Author> author = authorRepository.findById(authorId);
        return author.isPresent() ? author.get() : null;
    }

    public Author insertAuthor(Author author)
    {
        return authorRepository.save(author);
    }

    public void updateAuthor(Author author)
    {
        authorRepository.save(author);
    }
}
