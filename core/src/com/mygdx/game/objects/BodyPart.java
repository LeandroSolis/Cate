package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.objects.Snake;

public class BodyPart {
    private Snake snake;
    public int x,y;
    private Texture texture;

    public BodyPart(Snake snake, Texture texture){
        this.texture = texture;
        this.snake = snake;
    }

    public void updateBodyPosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void draw(Batch batch, int snakeX,int snakeY){
        if(snake != null){
            if(!(x==snake.x && y==snake.y))batch.draw(texture,x,y);
        } else if(!(x==snakeX && y==snakeY))batch.draw(texture,x,y);
    }
}
