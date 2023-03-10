package com.celerity.mobilegameserver.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


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
    @Column(name = "gold")
    private long gold;
    @Column(name = "gems")
    private int gems;
    @OneToMany(mappedBy = "player", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Hero> heroes = new ArrayList<>();

    public Player(){ }
    public Player(String token){
        this.gold = 200;
        this.token = token;
    }

    public Player(String name, String token, long gold, int gems, List<Hero> heroes) {
        this.name = name;
        this.gold = gold;
        this.gems = gems;
        this.token = token;
        this.heroes = heroes;
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

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public int getGems() {
        return gems;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
