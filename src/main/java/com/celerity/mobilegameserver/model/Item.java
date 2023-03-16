package com.celerity.mobilegameserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount")
    private int amount;
    @Column(name = "item_type_id")
    private int typeId;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
