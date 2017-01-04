package com.ben.midlife.Logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by 1firegamer on 1/3/2017.
 */
public class PlayerBody {
    private Player player;
    private CircleShape circle;
    private Vector2 position;

    public PlayerBody(World world){
        // First we create a body definition
        BodyDef bodyDef = new BodyDef();
// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
        bodyDef.type = BodyDef.BodyType.DynamicBody;
// Set our body's starting position in the world
        bodyDef.position.set(10, 10);
        this.position = bodyDef.position;

// Create our body in the world using our body definition
        Body body = world.createBody(bodyDef);
        body.setGravityScale(0);

// Create a circle shape and set its radius to 6
        circle = new CircleShape();
        circle.setRadius(1);

// Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f; // Make it bounce a little bit
// Create our fixture and attach it to the body
        Fixture fixture = body.createFixture(fixtureDef);

// Remember to dispose of any shapes after you're done with them!
// BodyDef and FixtureDef don't need disposing, but shapes do.

    }
    public Vector2 getPosition(){
        return position;
    }
    public void dispose(){
        circle.dispose();
    }

}
