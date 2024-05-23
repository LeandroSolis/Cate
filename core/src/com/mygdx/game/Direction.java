package com.mygdx.game;

public enum Direction {
	//llama a las direcciones
    RIGHT,
    UP,
    LEFT,
    DOWN;
	

    public static int angle(Direction dir){
        return dir == null ? 0 : (dir.ordinal()+1)*90;
    }

}


