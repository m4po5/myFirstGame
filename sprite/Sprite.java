package myFirstGame.sprite;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Sprite {
    private Image image;
    private double positionX;
    private double positionY;
    private double height;
    private double width;

    public Sprite(){
        positionX = 0;
        positionY = 0;
    }

    public void setImage(Image i){
        image = i;
        height = i.getHeight();
        width = i.getWidth();
    }

    public Image getImage(){
        return image;
    }

    public double getHeight() {return height;}
    public double getWidth() {return width;}

    public void setPosition(double x, double y){
        positionX = x;
        positionY = y;
    }

    public double getPositionX(){
        return positionX;
    }

    public double getPositionY(){
        return positionY;
    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite sprite){
        return getBoundary().intersects(sprite.getBoundary());
    }

    public String toString(){
        return "Position: {" + positionX + "," + positionY + "}, "
                + "Height: " + height + ", Width: " + width;
    }

}
