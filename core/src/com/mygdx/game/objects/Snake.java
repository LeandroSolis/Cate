package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Direction;

import static com.mygdx.game.Direction.*;

public class Snake {
    public static final int SNAKE_MOVEMENT = 32;
    public int x, y;
    public Direction direction = UP;
    public boolean directionSet, hasHit;
    public Array<BodyPart> bodyParts = new Array<BodyPart>();
    public Texture snakeHead = new Texture(Gdx.files.internal("snakehead.png"));
    public Texture snakeBody = new Texture(Gdx.files.internal("snakebody.png"));
    private int snakeXBeforeUpdate =0, snakeYBeforeUpdate =0;

    public void updatePosition() {
        if (x >= Gdx.graphics.getWidth()) {
            x = 0;
        }
        if (x < 0) {
            x = Gdx.graphics.getWidth() - SNAKE_MOVEMENT;
        }
        if (y >= Gdx.graphics.getHeight()) {
            y = 0;
        }
        if (y < 0) {
            y = Gdx.graphics.getHeight() - SNAKE_MOVEMENT;
        }
    }

    private void updateIfNotOppositeDirection(Direction newSnakeDirection, Direction oppositeDirection) {
        if (direction != oppositeDirection || this.bodyParts.size == 0) direction = newSnakeDirection;
    }

    public void updateDirection(Direction newDirection) {
        if (!directionSet && direction != newDirection) {
            directionSet = true;
            switch (newDirection) {
                case LEFT: {
                    updateIfNotOppositeDirection(newDirection, RIGHT);
                }
                break;
                case RIGHT: {
                    updateIfNotOppositeDirection(newDirection, LEFT);
                }
                break;
                case UP: {
                    updateIfNotOppositeDirection(newDirection, DOWN);
                }
                break;
                case DOWN: {
                    updateIfNotOppositeDirection(newDirection, UP);
                }
                break;
            }
        }
    }

    public void moveSnake(){
        this.snakeXBeforeUpdate=x;
        this.snakeYBeforeUpdate=y;
        switch(direction){
            case RIGHT: {
                x+=SNAKE_MOVEMENT;
                return;
            }
            case LEFT: {
                x-=SNAKE_MOVEMENT;
                return;
            }
            case UP: {
                y+=SNAKE_MOVEMENT;
                return;
            }
            case DOWN: {
                y-=SNAKE_MOVEMENT;
                return;
            }
        }
    }


    public void updateBodyPartsPosition(){
        if(this.bodyParts.size>0){
            BodyPart bodyPart=this.bodyParts.removeIndex(0);
            bodyPart.updateBodyPosition(this.snakeXBeforeUpdate,this.snakeYBeforeUpdate);
            this.bodyParts.add(bodyPart);
        }
    }

    public void checkForOutOfBounds(){
        this.updatePosition();
    }

    public boolean checkSnakeBodyCollision(Array<BodyPart> bodyParts){
        for(BodyPart bodyPart: bodyParts){
            if(bodyPart.x == x && bodyPart.y==y) {
                return true;
            }
        }
        return false;
    }

    public void draw(SpriteBatch batch) {
        TextureRegion head = new TextureRegion(this.snakeHead);
        //with TextureRegions
        batch.draw(
                head,
                x,
                y,
                head.getRegionWidth()/2,
                head.getRegionHeight()/2, head.getRegionWidth(), head.getRegionHeight(), 1,1, Direction.angle(direction));
        //batch.draw(this.snakeHead, this.x,this.y);
        for(BodyPart bodyPart: this.bodyParts){
            bodyPart.draw(batch,bodyPart.x,bodyPart.y);
        }
    }

    public void grow(){
        System.out.println("grow !");
        BodyPart bodyPart = new BodyPart(this,this.snakeBody);
        bodyPart.updateBodyPosition(this.x, this.y);
        this.bodyParts.insert(0,bodyPart);
    }
    public void grow(int x, int y){
        System.out.println(bodyParts.size);
        BodyPart bodyPart = new BodyPart(this,this.snakeBody);
        bodyPart.updateBodyPosition(x, y);
        this.bodyParts.insert(0,bodyPart);
    }


    public void move(int newX, int newY){
        snakeXBeforeUpdate = x;
        snakeYBeforeUpdate = y;
        x = newX;
        y = newY;
    }
}