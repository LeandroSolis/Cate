package com.mygdx.game.objects.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.background;

public class MenuScreen implements Screen {

    private OrthographicCamera camera;
    private Stage stage;

    MyGdxGame juego;

    public MenuScreen(final MyGdxGame juego) {
        this.juego = juego;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage = new Stage();

        // Create a table to organize the buttons
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Create buttons with ClickListeners
        final TextButton jugarButton = createButton("1 Jugador");
        final TextButton jugar2Button = createButton("Online");
        TextButton servidorButton = createButton("Servidor");
        TextButton salirButton = createButton("Salir");

        jugarButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Jugar button click
                System.out.println("Jugar clicked!");
                juego.setScreen(new Pantalla1Jugador());
            }
        });
        jugar2Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Jugar button click
                System.out.println("Jugar clicked!");
                Gdx.input.setInputProcessor(null);
                juego.setScreen(new PantallaOnline(juego));
            }
        });

        servidorButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Servidor button click
                System.out.println("Servidor clicked!");
                Gdx.input.setInputProcessor(null);
                juego.setScreen(new PantallaServidor(juego));
            }
        });

        salirButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Salir button click
                System.out.println("Salir clicked!");
                Gdx.app.exit();

            }
        });

        // Add buttons to the table
        table.add(jugarButton).padBottom(20).row();
        table.add(jugar2Button).padBottom(20).row();
        table.add(servidorButton).padBottom(20).row();
        table.add(salirButton);

        Gdx.input.setInputProcessor(stage);
    }

    private TextButton createButton(String text) {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = MyGdxGame.createText();
        return new TextButton(text, style);
    }

    @Override
    public void show() {
        // This method is called when the screen is set as the current screen.
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

    // Other methods...

    @Override
    public void dispose() {
        // Dispose of any resources when the screen is no longer needed.
        stage.dispose();
    }
}
