package com.generation.SpringSecurityJWT.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "text")//Este campo no va a ser de tipo varchar sino va a ser de tipo text
    private String content;//Dado que el contenido puede tener mas de 255 caracteres usamos columnDefinition para poder almacenar mas caracteres

    @ManyToOne//Muchas publicaciones pueden corresponder a un usuario
    @JsonProperty(access = Access.WRITE_ONLY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
