package myFirstGame.moneyCollectingGame.tests;

import myFirstGame.moneyCollectingGame.BriefcaseController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BriefcaseControllerTest {
    @Test
    void BriefcaseControllerInitialize(){
        BriefcaseController bc = new BriefcaseController();

        assertNotNull(bc.getBriefcaseSprite());
        assertNotNull(bc.getBriefcaseSprite().getImage());
        assertEquals(0, bc.getVelocityIncrement());
    }

    @Test
    void setBriefcaseTest() {
        BriefcaseController bc = new BriefcaseController();
        double x = 0.0;
        double y = 10.0;

        bc.setBriefcasePosition(x,y);

        assertEquals(x, bc.getBriefcaseSprite().getPositionX());
        assertEquals(y, bc.getBriefcaseSprite().getPositionY());
    }

    @Test
    void setBoostThresholdTest(){
        BriefcaseController bc = new BriefcaseController();
        int bt = 5;

        bc.setBoostThreshold(bt);

        assertEquals(bt, bc.getBoostThreshold());
    }

    @Test
    void setVelocityIncrementTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 15.3;

        bc.setVelocityIncrement(v);

        assertEquals(v, bc.getVelocityIncrement());
    }

    @Test
    void setVelocityIncrementInvalidTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = -11.33;

        bc.setVelocityIncrement(v);

        assertEquals(0, bc.getVelocityIncrement());
    }

    @Test
    void processKeyboardInputCodeYTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10;
        bc.setVelocityIncrement(v);

        String code = "DOWN";
        bc.processKeyboardInputCode(code);
        assertEquals(v, bc.getBriefcaseSprite().getPositionY());

        code = "UP";
        bc.processKeyboardInputCode(code);
        assertEquals(v, bc.getBriefcaseSprite().getPositionY());

        bc.processKeyboardInputCode(code);
        assertEquals(0, bc.getBriefcaseSprite().getPositionY());
    }

    @Test
    void processKeyboardInputCodeXTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10;
        bc.setVelocityIncrement(v);

        String code = "RIGHT";
        bc.processKeyboardInputCode(code);
        assertEquals(v, bc.getBriefcaseSprite().getPositionX());

        code = "LEFT";
        bc.processKeyboardInputCode(code);
        assertEquals(v, bc.getBriefcaseSprite().getPositionX());

        bc.processKeyboardInputCode(code);
        assertEquals(0, bc.getBriefcaseSprite().getPositionX());
    }

    @Test
    void processKeyboardInputDownContinuedTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10.0;
        bc.setVelocityIncrement(v);
        int c = 3;
        String code = "DOWN";

        for(int i = 0; i < c; i++ )
            bc.processKeyboardInputCode(code);

        assertEquals(c * v, bc.getBriefcaseSprite().getPositionY());
    }

    @Test
    void processKeyboardInputUpContinuedTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10.0;
        bc.setVelocityIncrement(v);
        int c = 3;
        String code = "UP";

        for(int i = 0; i < c; i++ )
            bc.processKeyboardInputCode(code);

        assertEquals(c * v * -1, bc.getBriefcaseSprite().getPositionY());
    }

    @Test
    void processKeyboardInputRightContinuedTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10.0;
        bc.setVelocityIncrement(v);
        int c = 3;
        String code = "RIGHT";

        for(int i = 0; i < c; i++ )
            bc.processKeyboardInputCode(code);

        assertEquals(c * v, bc.getBriefcaseSprite().getPositionX());
    }
    @Test
    void processKeyboardInputLeftContinuedTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10.0;
        bc.setVelocityIncrement(v);
        int c = 3;
        String code = "LEFT";

        for(int i = 0; i < c; i++ )
            bc.processKeyboardInputCode(code);

        assertEquals(c * v * -1, bc.getBriefcaseSprite().getPositionX());
    }

    @Test
    void processKeyboardInputDownFirstBoostTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10;
        int boostThreshold = 5;
        bc.setVelocityIncrement(v);
        bc.setBoostThreshold(boostThreshold);
        String code = "DOWN";

        for( int i = 0; i < boostThreshold; i++)
            bc.processKeyboardInputCode(code);

        double start = bc.getBriefcaseSprite().getPositionY();
        bc.processKeyboardInputCode(code);
        double end = bc.getBriefcaseSprite().getPositionY();

        assertEquals(2*v, end - start);
    }

    @Test
    void processKeyboardInputUpFirstBoostTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10;
        int boostThreshold = 5;
        bc.setVelocityIncrement(v);
        bc.setBoostThreshold(boostThreshold);
        String code = "UP";

        for( int i = 0; i < boostThreshold; i++)
            bc.processKeyboardInputCode(code);

        double start = bc.getBriefcaseSprite().getPositionY();
        bc.processKeyboardInputCode(code);
        double end = bc.getBriefcaseSprite().getPositionY();

        assertEquals(2*v, start - end);
    }

    @Test
    void processKeyboardInputRightFirstBoostTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10;
        int boostThreshold = 5;
        bc.setVelocityIncrement(v);
        bc.setBoostThreshold(boostThreshold);
        String code = "RIGHT";

        for( int i = 0; i < boostThreshold; i++)
            bc.processKeyboardInputCode(code);

        double start = bc.getBriefcaseSprite().getPositionX();
        bc.processKeyboardInputCode(code);
        double end = bc.getBriefcaseSprite().getPositionX();

        assertEquals(2*v, end - start);
    }

    @Test
    void processKeyboardInputLeftFirstBoostTest(){
        BriefcaseController bc = new BriefcaseController();
        double v = 10;
        int boostThreshold = 5;
        bc.setVelocityIncrement(v);
        bc.setBoostThreshold(boostThreshold);
        String code = "LEFT";

        for( int i = 0; i < boostThreshold; i++)
            bc.processKeyboardInputCode(code);

        double start = bc.getBriefcaseSprite().getPositionX();
        bc.processKeyboardInputCode(code);
        double end = bc.getBriefcaseSprite().getPositionX();

        assertEquals(2*v, start - end);
    }

}