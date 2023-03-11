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
    @ElementCollection
    @CollectionTable(name = "player_items", joinColumns = @JoinColumn(name = "player_id"))
    @MapKeyJoinColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Item, Integer> items = new HashMap<>();

    public Player(){ }

    public Player(String token){
        this.token = token;
    }

    public Player(String name, String token, List<Hero> heroes, Map<Item, Integer> items) {
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

    public Map<Item, Integer> getItems() {
        return items;
    }

}
