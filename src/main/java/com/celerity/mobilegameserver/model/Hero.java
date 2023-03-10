package com.celerity.mobilegameserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "level")
    private int level;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "stars")
    private byte stars;

    @Column(name = "damage")
    private float damage;

    @Column(name = "max_hp")
    private float hp;

    public Hero() { }

    public Hero(CharacterType type) {
        this.level = 1;
        this.stars = 0;
        this.typeId = type.getTypeId();
        this.damage = type.getDamage();
        this.hp = type.getHp();
    }

    public Hero(Player player, int level, byte stars, float damage, float hp) {
        this.player = player;
        this.level = level;
        this.stars = stars;
        this.damage = damage;
        this.hp = hp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public byte getStars() {
        return stars;
    }

    public void setStars(byte stars) {
        this.stars = stars;
    }

    public float getDamage() { return damage; }

    public void setDamage(float damage) { this.damage = damage; }

    public float getHp() { return hp; }

    public void setHp(float hp) { this.hp = hp; }

    public int getTypeId() { return typeId; }

    public void setTypeId(int typeId) { this.typeId = typeId; }
}
