package com.hamidur.springBootCRUDRESTfulWebservices.dbModels;

import java.util.List;
import java.util.Objects;

public class Author
{
    private Long authorId;
    private String firstName;
    private String lastName;
    private List<Post> posts;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getAuthorId(), author.getAuthorId()) &&
                Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getLastName(), author.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
