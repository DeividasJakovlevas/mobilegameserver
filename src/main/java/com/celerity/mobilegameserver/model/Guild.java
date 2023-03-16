package com.celerity.mobilegameserver.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guilds")
public class Guild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;
    @Column(name = "season_points")
    private int seasonPoints;

    @Column(name = "players")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Player> players;

    @OneToOne
    @Column(name = "owner_id")
    private Player owner;

    public Guild() {
    }

    public Guild(String name, Player owner) {
        this.name = name;
        this.owner = owner;
    }

    public Guild(long id, String name, int level, int seasonPoints, List<Player> players, Player owner) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.seasonPoints = seasonPoints;
        this.players = players;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getSeasonPoints() {
        return seasonPoints;
    }

    public void setSeasonPoints(int seasonPoints) {
        this.seasonPoints = seasonPoints;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
