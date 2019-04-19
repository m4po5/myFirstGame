package myFirstGame.sprite.tests;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import myFirstGame.sprite.Sprite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpriteTests {

    @Test
    void SpriteInitialize(){
        Sprite sprite = new Sprite();

        assertTrue(sprite.getPositionX() == 0);
        assertTrue(sprite.getPositionY() == 0);
        assertNull(sprite.getImage());
        assertTrue(sprite.getHeight() == 0);
        assertTrue(sprite.getWidth() == 0);
    }

    @Test
    void setImage() {
        Sprite sprite = new Sprite();
        String imageName = "images/moneybag.png";
        Image image = new Image(getClass().getResourceAsStream(imageName));

        sprite.setImage(image);

        assertTrue(sprite.getImage() == image);
        assertTrue(sprite.getHeight() == image.getHeight());
        assertTrue(sprite.getWidth() == image.getWidth());
    }

    @Test
    void setPosition(){
        Sprite sprite = new Sprite();
        double x = 10;
        double y = 20;

        sprite.setPosition(x,y);

        assertTrue(sprite.getPositionX() == x && sprite.getPositionY() == y);
    }

    @Test
    void getBoundary(){
        Sprite sprite = getSprite();

        Rectangle2D rect = sprite.getBoundary();

        assertEquals(rect.getHeight(), sprite.getHeight());
        assertEquals(rect.getWidth(), sprite.getWidth());
        assertEquals(rect.getMinX(), sprite.getPositionX());
        assertEquals(rect.getMinY(), sprite.getPositionY());
    }

    private Sprite getSprite() {
        Sprite sprite = new Sprite();
        sprite.setPosition(50,30);
        sprite.setImage(new Image(getClass().getResourceAsStream("images/moneybag.png")));
        return sprite;
    }

    @Test
    void intersects(){
        Sprite sprite = getSprite();
        Sprite sprite2 = getSprite();
        sprite2.setPosition(sprite.getPositionX() + sprite.getWidth() / 2, sprite.getPositionY() + sprite.getHeight() / 2);

        assertTrue(sprite.intersects(sprite2));
    }

    @Test
    void toStringTest(){
        Sprite sprite = new Sprite();
        sprite.setPosition(30,20);
        String message = "Position: {30.0,20.0}, Height: 0.0, Width: 0.0";

        assertEquals(sprite.toString(), message);
    }

}