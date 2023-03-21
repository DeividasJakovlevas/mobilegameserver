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
    @OneToMany(mappedBy = "player", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Unit> units = new ArrayList<>();

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

    public Player(String name, String token, List<Unit> units, List<Item> items) {
        this.name = name;
        this.token = token;
        this.units = units;
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

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) { this.units = units; }

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
