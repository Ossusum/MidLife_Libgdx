package com.ben.midlife.GUI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.ben.midlife.Logic.Map;
import com.ben.midlife.Logic.PlayerBody;
import com.ben.midlife.Logic.Tile;
import com.ben.midlife.MidLife;

import java.util.Random;

/**
 * Created by 1firegamer on 1/2/2017.
 */
public class MovementScreen implements Screen {
    private MidLife midLife;
    private Map map;
    private World world;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private PlayerBody playerBody;

    public MovementScreen(MidLife midLife) {
        this.midLife = midLife;
        this.world = new World(new Vector2(0, -10), true);
        // create the camera and the SpriteBatch
        this.camera = new OrthographicCamera();

        this.map = new Map(this.world, new Random().nextInt(10)+10,new Random().nextInt(10)+10);
        this.playerBody = new PlayerBody(this.world);
        this.camera.setToOrtho(false, 10, 10);
        //this.camera.translate(-camera.viewportWidth / 2, -camera.viewportHeight / 2, 0);
        map.generateRandomMap();
        this.debugRenderer = new Box2DDebugRenderer();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        this.camera.position.set(playerBody.getPosition(), 0);
        camera.update();
        world.step(1 / 60f, 6, 2);

        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.


        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        debugRenderer.render(world, camera.combined);

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
        map.dispose();
    }
}
