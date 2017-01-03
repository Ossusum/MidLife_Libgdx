package com.ben.midlife.Logic;

import java.util.ArrayList;

/**
 * Created by Benny on 11/21/2016.
 */
public class BattleManager {
    private ArrayList<Entity> entities;
    private Entity currentEntity;
    private Entity client;

    public BattleManager(ArrayList<Entity> entities){
        this.entities = entities;
        currentEntity = entities.get(0);
        client = entities.get(0);
    }


    //TODO case of a player killing another entity
    public void attack(Entity chosenEntity){
        if (!chosenEntity.isDead()) {
            chosenEntity.setHealth(chosenEntity.getHealth() - currentEntity.getAttack());
            if (chosenEntity.getHealth() <= 0) {
                chosenEntity.setDead(true);
            }
        }
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

    public boolean auto(Entity chosenEntity){
        attack(chosenEntity);
        findNextCurrent();
        while (!currentEntity.equals(client)) {
            attack(client);
            findNextCurrent();
        }
        System.out.println(this.toString());
        return client.isDead();
    }


    private boolean findNextCurrent(){
        for (int i= entities.indexOf(currentEntity); i < entities.size(); ++i){
            if (i+1 == entities.size())
                i = -1;
            if (!entities.get(i+1).isDead()) {
                currentEntity = entities.get(i + 1);
                return true;
            }
        }
        return false;
    }

    public boolean isLastAlive(){
        for (int i = 0; i<entities.size();++i){
            if (!entities.get(i).equals(client))
                if (!entities.get(i).isDead())
                    return false;
        }
        return true;
    }

    public String toString(){
        String currentState = "";
        currentState += "Current Player: " + currentEntity.getName() + "\nDead Players:\n";
        for (int i = 0; i <entities.size();++i){
            if (entities.get(i).isDead())
                currentState += entities.get(i).getName() + " HP: "+entities.get(i).getHealth()  +"\n";
        }
        currentState += "\nAlive Players:\n";
        for (int i = 0; i <entities.size();++i){
            if (!entities.get(i).isDead())
                currentState += entities.get(i).getName()  + " HP: "+entities.get(i).getHealth()  +"\n";
        }
        return currentState;
    }






}
