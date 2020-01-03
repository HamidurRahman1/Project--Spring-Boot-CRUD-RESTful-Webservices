package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Comment;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService
{
    @Autowired
    private CommentRepository commentRepository;

    public Comment getCommentById(Long commentId)
    {
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.isPresent() ? comment.get() : null;
    }

    public Comment insertComment(Comment comment)
    {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment)
    {
        Comment newComment = new Comment();
        newComment.setCommentId(comment.getCommentId());
        newComment.setContent(comment.getContent());
        newComment.setArticle(commentRepository.findById(comment.getCommentId()).get().getArticle());
        return commentRepository.save(newComment);
    }

    public void deleteComment(Long commentId)
    {
        commentRepository.deleteById(commentId);
    }
}
