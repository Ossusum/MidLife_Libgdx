package com.ben.midlife.Logic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;



/**
 * Created by 1firegamer on 1/2/2017.
 */
public class Tile {
    private static final int TILE_SIDE_SIZE = 1;//Tiles will be offset by this integer
    private Texture img;
    private BodyDef bodyDef;
    private Vector2 position;
    private Body body;
    private PolygonShape box;
    private World world;

    public Tile(World world, Vector2 position){
        this.world = world;
        this.position = position;
    }

    public void createTile(){
        bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(TILE_SIDE_SIZE * position.x * 2, TILE_SIDE_SIZE * position.y * 2));
        body = world.createBody(bodyDef);
        box = new PolygonShape();
        box.setAsBox(TILE_SIDE_SIZE,TILE_SIDE_SIZE);
        body.createFixture(box,0f);
    }

    public void dispose(){
        box.dispose();
    }
}
