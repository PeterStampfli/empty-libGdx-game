package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.utilities.Basic;
import com.mygdx.game.utilities.Device;

/**
 * Created by peter on 1/19/17.
 */

public class GameScreen extends ScreenAdapter {

    private TheGame theGame;
    private Device device;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;


    public GameScreen(TheGame theGame){
        this.theGame=theGame;
        device=theGame.device.createShapeRenderer();
        shapeRenderer=device.shapeRenderer;
        spriteBatch=device.spriteBatch;
        viewport=device.viewport;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public void drawDebug(){
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.end();
    }

    public void draw(){
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        spriteBatch.end();
    }

    @Override
    public void render(float delta){

        viewport.apply(true);

        Basic.clearBackground(Color.CYAN);

        draw();
        drawDebug();
    }

}
