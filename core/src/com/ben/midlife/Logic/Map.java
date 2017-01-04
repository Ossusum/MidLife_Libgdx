package com.ben.midlife.Logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 1firegamer on 1/3/2017.
 */
public class Map {
    private Tile[][] Map;
    private World world;
    private int sizeX, sizeY;
    private Random random;

    public Map(World world, int sizeX, int sizeY){
        this.world = world;
        this.Map = new Tile[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.random = new Random();
    }

    public void generateRandomMap(){
        for (int i = 0; i < sizeX; ++i){
            for (int j = 0; j < sizeY; ++j) {
                if (i == sizeX-1 || i == 0 || j == sizeY-1 || j == 0 || random.nextInt(sizeX)+1 % i == 2 ) {
                    Map[i][j] = new Tile(this.world, new Vector2(i, j));
                    Map[i][j].createTile();
                }
            }
        }
    }

    public void dispose(){
        for (int i = 0; i < Map.length; ++i){
            for (int j = 0; j < Map[i].length; ++j){
                if (Map[i][j] != null){
                    Map[i][j].dispose();
                }
            }
        }
    }

}
