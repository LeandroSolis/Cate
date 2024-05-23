package com.mygdx.game.objects.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.background;
// pantallas
public class PantallaGameover implements Screen {
    private final MyGdxGame game; // Replace with your game class

    public PantallaGameover(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        MyGdxGame.jugadorNumero = -1;
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Draw the generated text
        game.batch.begin();
        game.batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        MyGdxGame.createText().draw(game.batch, "Game Over", Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f + 50);
        MyGdxGame.createText().draw(game.batch, MyGdxGame.ganador == 2? "EMPATE!" : "Gano el jugador "+ (MyGdxGame.ganador+1), Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f);
        game.batch.end();

        // Check for input to return to MainMenuScreen
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        // Resize the stage or other elements if needed
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
    }
}
