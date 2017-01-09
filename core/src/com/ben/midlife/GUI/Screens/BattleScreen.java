package com.ben.midlife.GUI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ben.midlife.Logic.BattleManager;
import com.ben.midlife.MidLife;

/**
 * Created by Benny on 1/2/2017.
 */

public class BattleScreen implements Screen {
    private MidLife game;
    private MovementScreen previousScreen;
    private BattleManager manager;
    private Button attackButton;
    private TextButton runButton;
    private Stage stage;

    public BattleScreen(MidLife game, MovementScreen previousScreen){
        this.game = game;
        this.previousScreen = previousScreen;
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        this.attackButton = new TextButton("Attack",style);
        this.runButton = new TextButton("Run", style);
        this.runButton.setPosition(100,100);
        this.runButton.setWidth(100);
        this.runButton.setHeight(100);
        this.runButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                BattleScreen.this.game.setScreen(BattleScreen.this.previousScreen);
            }
        });
        //BattleScreen.this.game.setScreen(BattleScreen.this.previousScreen);
        this.attackButton.setPosition(200,100);
        this.stage = new Stage(new ExtendViewport(1000,400));
        Gdx.input.setInputProcessor(stage);
        stage.addActor(attackButton);
        stage.addActor(runButton);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        // tell the camera to update its matrices.
        //game.setScreen(previousScreen);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
