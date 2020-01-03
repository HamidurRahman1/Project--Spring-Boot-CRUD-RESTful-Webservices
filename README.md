# Project--SpringBootCRUDRESTfulWebservices
A basic spring boot RESTful webservices example with CRUD 
functionality.

Tools I used for this-
<ul>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>Hibernate</li>
    <li>MySQL</li>
    <li>Jackson</li>
</ul>

<h3>Endpoints - </h3>
<p>All end points are mapped to <strong>/api</strong></p>
<ul>
    <li><h4>Get</h4>
        <ul>
            <li>/author/{authorId}</li>
            <li>/authors</li>
            <li>/author/{authorId}/articles</li>
            <li>/articles</li>
            <li>/article/{articleId}</li>
            <li>/comment/{commentId}</li>
        </ul>
    </li>
    <li><h4>Post</h4>
        <ul>
            <li>/author/{authorId}/insertArticle</li>
            <li>/article/{articleId}/insertComment</li>
            <li>/insertAuthor</li>
        </ul>
    </li>
    <li><h4>Put</h4>
        <ul>
            <li>/author/update</li>
            <li>/comment/update</li>
            <li>/article/update</li>
        </ul>
    </li>
    <li><h4>Delete</h4>
        <ul>
            <li>/delete/author/{authorId}</li>
            <li>/delete/article/{articleId}</li>
            <li>/delete/comment/{commentId}</li>
        </ul>
    </li>
</ul>

 