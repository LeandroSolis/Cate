package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.objects.screens.MenuScreen;
import com.network.ClienteHilo;
import com.network.ServidorHilo;

public class MyGdxGame extends Game {

	private static FreeTypeFontGenerator generator;
	public SpriteBatch batch;



	public static int jugadorNumero = -1;

	public static int ganador;
	//
	public static Texture background;

	@Override
	public void create () {
		background = new Texture("background.png");
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {
		generator.dispose();
		batch.dispose();
		screen.dispose();
	}

	public static BitmapFont createText(){
		if(generator == null) generator = new FreeTypeFontGenerator(Gdx.files.internal("Bubblegum.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 32; // Set your desired font size
		BitmapFont font = generator.generateFont(parameter);
		return font;
	}
}
