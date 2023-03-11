package com.celerity.mobilegameserver.model;

public enum ItemType {
    GOLD(1),
    GEMS(2);

    private final int id;

    ItemType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ItemType fromId(int id) {
        for (ItemType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid item type ID: " + id);
    }
}