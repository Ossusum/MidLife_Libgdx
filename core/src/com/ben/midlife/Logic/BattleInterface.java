package com.ben.midlife.Logic;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Benny on 1/1/2017.
 */
public class BattleInterface {
    private BattleManager manager;
    private Player player;

    public BattleInterface(ArrayList<Entity> listOfEntities, Player player){
        listOfEntities.add(0,player);
        this.manager = new BattleManager(listOfEntities);
        this.player = player;
    }

    public BattleInterface(Player player){
        ArrayList<Entity> listOfEntities = new ArrayList<Entity>();
        listOfEntities.add(player);
        listOfEntities.add(new Entity("Ogre"));
        this.manager = new BattleManager(listOfEntities);
        this.player = player;
    }

    public void battle(){
        Scanner scan = new Scanner(System.in);

        while(!player.isDead() && !manager.isLastAlive()) {
            ArrayList<Entity> entities = manager.getEntities();
            System.out.println("\nChoose an enemy\n");

            //show list of alive players
            for (int i = 1; i < entities.size();++i){
                if (!entities.get(i).isDead())
                    System.out.println(i+" "+ entities.get(i).getName());
            }
            //get input
            int index = scan.nextInt();
            //check input
            if (index < entities.size() && !entities.get(index).isDead()){
                //commence the attack
                manager.auto(entities.get(index));
            }else{
                System.out.println("\nInvalid Selection");
            }
        }
        //end while
        // Test Output for results of battle
        if (manager.isLastAlive()){
            System.out.println("you won");
        }
        // End of battle loop
    }



}
