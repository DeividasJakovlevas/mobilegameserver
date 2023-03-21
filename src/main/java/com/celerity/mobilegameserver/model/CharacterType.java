package com.celerity.mobilegameserver.model;

import java.util.Arrays;

public enum CharacterType {
    UNIT_MELEE_WARRIOR(0,30,2),
    UNIT_RANGED_ARCHER(1,20,3),
    UNIT_RANGED_HEALER(2,15,3);


    private int typeId;
    private float hp;
    private float damage;

    CharacterType(int typeId, int hp, int damage) {
        this.typeId = typeId;
        this.hp = hp;
        this.damage = damage;
    }

    public int getTypeId() {
        return typeId;
    }

    public float getHp() {
        return hp;
    }

    public float getDamage() {
        return damage;
    }
}
