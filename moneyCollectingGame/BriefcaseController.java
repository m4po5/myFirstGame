package myFirstGame.moneyCollectingGame;

import javafx.scene.image.Image;
import myFirstGame.sprite.*;

public class BriefcaseController {
    private FloatingSprite briefcase;
    private double velocityIncrement;
    private int boostThreshold;

    public BriefcaseController(){
        briefcase = new FloatingSprite();
        briefcase.setImage(new Image(getClass().getResourceAsStream("images/briefcase.png")));
        velocityIncrement = 0;
        boostThreshold = 5;
    }

    public Sprite getBriefcaseSprite() {
        return briefcase;
    }

    public void setBriefcasePosition(double x, double y) {
        briefcase.setPosition(x,y);
    }

    public void setVelocityIncrement(double v) {
        if(v < 0)
            velocityIncrement = 0;
        else
            velocityIncrement = v;
    }

    public double getVelocityIncrement() {
        return velocityIncrement;
    }

    public void setBoostThreshold(int bt) {
        if(bt > 0)
            boostThreshold = bt;
    }

    public int getBoostThreshold(){
        return boostThreshold;
    }

    public void processKeyboardInputCode(String code) {
        switch (code){
            case "UP":
                processUp();
                break;
            case "DOWN":
                processDown();
                break;
            case "LEFT":
                processLeft();
                break;
            case "RIGHT":
                processRight();
                break;
            default:
                return;
        }

        briefcase.move();
    }

    private void processDown(){
        double velocity = briefcase.getVelocityY();
        if(velocity < velocityIncrement)
        {
            briefcase.accelerateDownBy(velocityIncrement);
            countDown = 0;
        }
        else
            checkAndEngageBoostDown();
    }

    private int countDown;
    private void checkAndEngageBoostDown(){
        if (countDown < boostThreshold-1)
            countDown++;
        else
            briefcase.accelerateDownBy(velocityIncrement);
    }

    private void processUp(){
        double velocity = briefcase.getVelocityY();
        if(velocity*-1 < velocityIncrement)
        {
            briefcase.accelerateUpBy(velocityIncrement);
            countUp = 0;
        }
        else
            checkAndEngageBoostUp();
    }

    private int countUp;
    private void checkAndEngageBoostUp(){
        if (countUp < boostThreshold-1)
            countUp++;
        else
            briefcase.accelerateUpBy(velocityIncrement);
    }

    private void processRight() {
        double velocity = briefcase.getVelocityX();
        if(velocity < velocityIncrement)
        {
            briefcase.accelerateRightBy(velocityIncrement);
            countRight = 0;
        }
        else
            checkAndEngageBoostRight();
    }

    private int countRight;
    private void checkAndEngageBoostRight() {
        if ( countRight < boostThreshold-1)
            countRight++;
        else
            briefcase.accelerateRightBy(velocityIncrement);
    }

    private void processLeft() {
        double velocity = briefcase.getVelocityX();
        if(velocity*-1 < velocityIncrement)
        {
            briefcase.accelerateLeftBy(velocityIncrement);
            countLeft = 0;
        }
        else
            checkAndEngageBoostLeft();
    }

    private int countLeft;
    private void checkAndEngageBoostLeft() {
        if(countLeft < boostThreshold-1)
            countLeft++;
        else
            briefcase.accelerateLeftBy(velocityIncrement);
    }
}
