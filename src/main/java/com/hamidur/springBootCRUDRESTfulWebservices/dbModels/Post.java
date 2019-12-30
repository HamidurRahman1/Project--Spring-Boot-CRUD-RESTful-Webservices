package com.hamidur.springBootCRUDRESTfulWebservices.dbModels;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Post
{
    private Long postId;
    private String title;
    private String body;
    private Date publishedDate;
    private Author author;
    private List<Comment> comments;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getPostId(), post.getPostId()) &&
                Objects.equals(getTitle(), post.getTitle()) &&
                Objects.equals(getPublishedDate(), post.getPublishedDate()) &&
                Objects.equals(getAuthor(), post.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getTitle(), getPublishedDate(), getAuthor());
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", publishedDate=" + publishedDate +
                ", author=" + author.getAuthorId() +
                ", comments=" + comments +
                '}';
    }
}
