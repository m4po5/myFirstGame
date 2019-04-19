package myFirstGame.sprite.tests;

import myFirstGame.sprite.FloatingSprite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloatingSpriteTest {

    @Test
    void FloatingSpriteInitialize(){
        FloatingSprite sprite = new FloatingSprite();

        assertEquals(0, sprite.getVelocityX());
        assertEquals(0, sprite.getVelocityY());
    }

    @Test
    void setVelocity(){
        FloatingSprite sprite = new FloatingSprite();
        double x = 20;
        double y = -20;

        sprite.setVelocity(x,y);

        assertEquals(x, sprite.getVelocityX());
        assertEquals(y, sprite.getVelocityY());
    }

    @Test
    void accelerateUp(){
        FloatingSprite sprite = new FloatingSprite();
        double y = 10;

        sprite.accelerateUp(y);
        sprite.accelerateUp(y);

        assertEquals(y * -2, sprite.getVelocityY());
    }

    @Test
    void accelerateDown(){
        FloatingSprite sprite = new FloatingSprite();
        double y = 10;

        sprite.accelerateDown(y);
        sprite.accelerateDown(y);

        assertEquals(2*y, sprite.getVelocityY());
    }

    @Test
    void accelerateLeft(){
        FloatingSprite sprite = new FloatingSprite();
        double x = 10;

        sprite.accelerateLeft(x);
        sprite.accelerateLeft(x);

        assertEquals(x * -2,sprite.getVelocityX());
    }

    @Test
    void accelerateRight(){
        FloatingSprite sprite = new FloatingSprite();
        double x = 10;

        sprite.accelerateRight(x);
        sprite.accelerateRight(x);

        assertEquals(2*x,sprite.getVelocityX());
    }

    @Test
    void move(){
        FloatingSprite sprite = new FloatingSprite();
        double x = -10;
        double y = 50;
        sprite.setVelocity(x,y);

        sprite.move();

        assertEquals(x, sprite.getPositionX());
        assertEquals(y, sprite.getPositionY());
    }

    @Test
    void toStringTest(){
        FloatingSprite sprite = new FloatingSprite();
        sprite.setVelocity(50,600);
        String message = "Position: {0.0,0.0}, Height: 0.0, Width: 0.0, Velocity: {50.0,600.0}";

        assertEquals(message, sprite.toString());
    }
}