package com.ben.midlife.Logic;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.ben.midlife.GUI.Screens.BattleScreen;
import com.ben.midlife.GUI.Screens.MovementScreen;
import com.ben.midlife.MidLife;

/**
 * Created by Benny on 1/7/2017.
 */

public class CollisionListener implements ContactListener {

    private MidLife game;
    private MovementScreen previousScreen;

    public CollisionListener(MidLife game, MovementScreen movementScreen){
        this.game = game;
        this.previousScreen = movementScreen;
        previousScreen.pause();
    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        if (contact.getFixtureB().getBody().getUserData().equals("Player") ||contact.getFixtureA().getBody().getUserData().equals("Player")){
            game.setScreen(new BattleScreen(this.game, this.previousScreen));
        }
    }
}
