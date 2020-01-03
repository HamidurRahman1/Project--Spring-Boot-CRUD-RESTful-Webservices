package com.hamidur.springBootCRUDRESTfulWebservices.dbModels;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment implements Serializable
{
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(name = "comment")
    private String comment;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    private Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(getCommentId(), comment1.getCommentId()) &&
                Objects.equals(getComment(), comment1.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getComment());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
