package com.ben.midlife.Logic;

import java.util.Arrays;

/**
 * Created by Benny on 11/16/2016.
 */
public class Entity {
    private String name;
    private Part[] bodyParts;
    private boolean isDead;
    private int health;
    private int attack;

    public Entity(String name){
        this.name = name;
        this.bodyParts = new Part[]{new Part("Head",10),new Part("Torso",30),new Part("Left Arm",15),new Part("Right Arm",15),new Part("Left Leg",15),new Part("Right Arm",15)};
        this.isDead = false;
        this.health = 1000;
        this.attack = 25;
    }

    public Entity(String name, Part[] bodyParts, boolean isDead, int health, int attack){
        this.name = name;
        this.bodyParts = bodyParts;
        this.isDead = isDead;
        this.health = health;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Part[] getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(Part[] bodyParts) {
        this.bodyParts = bodyParts;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public String toString() {
        return  "\nName: " + name +
                "\nHealth: " + health +
                "\nbodyParts: " + Arrays.toString(bodyParts) +
                "\nisDead = " + isDead +
                "\nAttack = " + attack;
    }
}
