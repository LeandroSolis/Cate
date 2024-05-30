package com.mygdx.game.objects.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Direction;
import com.mygdx.game.objects.Snake;

import static com.mygdx.game.MyGdxGame.background;

public class Pantalla1Jugador extends ScreenAdapter {
    private SpriteBatch batch;

    private static final float MOVE_TIME= 0.2f;
    private float timer = MOVE_TIME;
    private static final int SNAKE_MOVEMENT=32;

    private Texture apple;
    private boolean appleAvailable=false;
    private int appleX, appleY;

    private ShapeRenderer shapeRenderer;
    private static final int GRID_CELL=32;


    private enum STATE {
        PLAYING, GAME_OVER
    }
    private STATE state=STATE.PLAYING;

    private BitmapFont bitmapFont;
    private GlyphLayout layout = new GlyphLayout();

    private Viewport viewport;

    private static final String GAME_OVER_TEXT="Game Over!";

    private Snake snake;

    @Override
    public void show(){
        viewport = new FitViewport(800,800);

        shapeRenderer=new ShapeRenderer();
        batch=new SpriteBatch();
        apple=new Texture(Gdx.files.internal("apple.png"));
        bitmapFont = new BitmapFont();
        this.snake = new Snake();
    }

    @Override
    public void render(float delta){
        switch(state){
            case PLAYING: {
                queryInput();
                updateSnake(delta);
                checkAppleCollision();
                checkAndPlaceApple();

            }
            break;
            case GAME_OVER:{

            }
            break;
        }
        clearScreen();
        draw();
        drawGrid();
    }

    private void checkForOutOfBounds(){
        snake.updatePosition();
    }

    private void queryInput() {
        boolean lPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT) ||Gdx.input.isKeyPressed(Input.Keys.A);
        boolean rPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT)||Gdx.input.isKeyPressed(Input.Keys.D);;
        boolean uPressed = Gdx.input.isKeyPressed(Input.Keys.UP)||Gdx.input.isKeyPressed(Input.Keys.W);;
        boolean dPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN)||Gdx.input.isKeyPressed(Input.Keys.S);;
        if (lPressed) snake.updateDirection(Direction.LEFT);
        if (rPressed) snake.updateDirection(Direction.RIGHT);
        if (uPressed) snake.updateDirection(Direction.UP);
        if (dPressed) snake.updateDirection(Direction.DOWN);
    }




    private void checkAndPlaceApple(){
        if(!appleAvailable){
            do{
                appleX=MathUtils.random(Gdx.graphics.getBackBufferHeight()/SNAKE_MOVEMENT-1)*SNAKE_MOVEMENT;
                appleY=MathUtils.random(Gdx.graphics.getHeight()/SNAKE_MOVEMENT-1)*SNAKE_MOVEMENT;
                appleAvailable=true;
            } while (appleX==snake.x && appleY == snake.y);
        }
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void draw(){
        batch.begin();

        batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        snake.draw(batch);


        if (appleAvailable) {
            batch.draw(apple, appleX, appleY);
        }
        if (state == STATE.GAME_OVER) {
            layout.setText(bitmapFont, GAME_OVER_TEXT);
            bitmapFont.draw(batch, GAME_OVER_TEXT, viewport.getWorldWidth() / 2 - layout.width / 2, viewport.getWorldHeight() / 2 - layout.height / 2);
        }
        batch.end();
    }

    private void checkAppleCollision(){
        if(appleAvailable && appleX == snake.x && appleY == snake.y){
            snake.grow();
            appleAvailable = false;
        }
    }



    private void drawGrid(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for(int x=0;x<Gdx.graphics.getWidth();x+=GRID_CELL){
            for(int y=0;y<Gdx.graphics.getHeight();y+=GRID_CELL){
                shapeRenderer.rect(x, y, GRID_CELL, GRID_CELL);
            }
        }
        shapeRenderer.end();
    }

    private void updateSnake(float delta){
        if(!snake.hasHit){
            timer-=delta;
            if(timer<=0){
                timer=MOVE_TIME;
                //checkForOutOfBounds();
                snake.moveSnake();
                snake.checkForOutOfBounds();
                snake.updateBodyPartsPosition();
                if(snake.checkSnakeBodyCollision(snake.bodyParts)) {
                    state = STATE.GAME_OVER;
                }
                snake.directionSet = false;
            }
        }
    }


}
