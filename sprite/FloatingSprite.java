package myFirstGame.sprite;

public class FloatingSprite extends Sprite {
    private double velocityX;
    private double velocityY;

    public FloatingSprite(){
        super();
        velocityX = 0;
        velocityY = 0;
    }

    public void setVelocity(double x, double y){
        velocityX = x;
        velocityY = y;
    }

    public double getVelocityX(){
        return velocityX;
    }

    public double getVelocityY(){
        return velocityY;
    }

    public void accelerateUpBy(double y){
        velocityY += y * -1;
    }

    public void accelerateDownBy(double y){
        velocityY += y;
    }

    public void accelerateLeftBy(double x){
        velocityX += x * -1;
    }

    public void accelerateRightBy(double x){
        velocityX += x;
    }

    public void move(){
        setPosition(getPositionX() + velocityX, getPositionY() + velocityY);
    }

    public String toString(){
        return super.toString() + ", Velocity: {"+velocityX+","+velocityY+"}";
    }

}
