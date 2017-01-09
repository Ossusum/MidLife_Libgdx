package com.ben.midlife.GUI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.ben.midlife.Logic.CollisionListener;
import com.ben.midlife.Logic.Map;
import com.ben.midlife.Logic.Player;
import com.ben.midlife.Logic.PlayerBody;
import com.ben.midlife.Logic.Tile;
import com.ben.midlife.MidLife;
import com.sun.prism.image.ViewPort;

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
    private ExtendViewport viewPort;
    private Stage stage;

    public MovementScreen(MidLife midLife) {
        this.midLife = midLife;
        this.world = new World(new Vector2(0, 0), true);
        this.world.setContactListener(new CollisionListener(midLife, this));
        // create the camera and the SpriteBatch
        this.camera = new OrthographicCamera();
        this.map = new Map(this.world, new Random().nextInt(10)+10,new Random().nextInt(10)+10);
        this.playerBody = new PlayerBody(this.world);
        this.camera.setToOrtho(false, 10,10);
        //Gdx.app.getGraphics().setWindowedMode(1000,400);
        //this.camera.translate(-camera.viewportWidth / 2, -camera.viewportHeight / 2, 0);
        map.generateRandomMap();
        this.debugRenderer = new Box2DDebugRenderer();

        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.DOWN)
                playerBody.getPlayerBody().applyLinearImpulse(new Vector2(0,-2), new Vector2(0,-2), true);
                if (keycode == Input.Keys.UP)
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(0,2), new Vector2(0,2), true);
                if (keycode == Input.Keys.LEFT)
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(-2,0), new Vector2(-2,0), true);
                if (keycode == Input.Keys.RIGHT)
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(2,0), new Vector2(2,0), true);

                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                playerBody.getPlayerBody().setLinearVelocity(new Vector2(0,0));
                return true;
            }

            @Override
            public boolean keyTyped(char character) {
                if (character == 's')
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(0,-2), new Vector2(0,-2), true);
                if (character == 'w')
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(0,2), new Vector2(0,2), true);
                if (character == 'a')
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(-2,0), new Vector2(-2,0), true);
                if (character == 'd')
                    playerBody.getPlayerBody().applyLinearImpulse(new Vector2(2,0), new Vector2(2,0), true);

                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        world.step(1 / 60f, 6, 2);
        camera.position.set(playerBody.getPlayerBody().getPosition(), 0);
        camera.update();


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
