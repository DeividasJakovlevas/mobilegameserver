package com.celerity.mobilegameserver.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "token")
    private String token;
    @OneToMany(mappedBy = "player", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Hero> heroes = new ArrayList<>();

    @Column(name = "items")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "guild_id")
    private Guild guild;

    public Player(){ }

    public Player(String token){
        this.token = token;
    }

    public Player(String name, String token, List<Hero> heroes, List<Item> items) {
        this.name = name;
        this.token = token;
        this.heroes = heroes;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) { this.heroes = heroes; }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Item> getItems() {
        return items;
    }

}
