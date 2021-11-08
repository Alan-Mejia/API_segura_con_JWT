package com.generation.SpringSecurityJWT.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)//Se le dice que el campo no puede ser nulo
    private Long id;

    @Column(nullable = false, length = 200)//No nulo y con longitud de 200 caracteres
    private String name;

    @Column(nullable = false, length = 200)
    private String surname;

    @Column(nullable = true, length = 255)//Este campo si puede ser Nulo
    private String address;

    @Column(name = "email", unique = true)//Este campo va a ser unico, es decir no se puede repeti
    private String username;

    private String password;

    //MappedBy nos permite tener una relacion bidireccional, es decir, desde la tabla post se puede acceder a user y viceversa
    @OneToMany(mappedBy = "user")//Relacion uno a muchos y va hacer la relacion a traves del campo user; UN USUARIO PUEDE TENER MUCHAS PUBLICACIONES
    private List<Post> posts;//Una lista de publicaciones

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
