package com.ben.midlife.GUI;

import com.ben.midlife.Logic.BattleInterface;
import com.ben.midlife.Logic.Entity;
import com.ben.midlife.Logic.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Benny on 11/21/2016.
 */
public class Client {

    public static void main(String[] args){
        test();
        //StartGame();
    }

    public static void test(){

        Scanner scan = new Scanner(System.in);

        //Set test data
        Player player = new Player("Ossusum");
        System.out.println(player);

        Entity monster = new Entity("Goblin");
        monster.setHealth(250);
        System.out.println(monster);

        Entity second = new Entity("Ogre");
        second.setHealth(250);
        System.out.println(second);

        //loading characters
        ArrayList<Entity> test = new ArrayList<Entity>();
        test.add(monster);
        test.add(second);

        BattleInterface battleInterface = new BattleInterface(test,player);
        battleInterface.battle();

    }

}


