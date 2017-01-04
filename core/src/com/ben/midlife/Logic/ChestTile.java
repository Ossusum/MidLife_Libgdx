package com.ben.midlife.Logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by 1firegamer on 1/3/2017.
 */
public class ChestTile extends Tile {
    public ChestTile(World world, Vector2 position) {
        super(world, position);
    }

    //Collision will make animation of chest opening
}
