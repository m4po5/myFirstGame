package myFirstGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

public class MyFirstGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception{

        theStage.setTitle("Money-Collecting Game");

        Group root = new Group();
        Scene scene = new Scene(root);
        theStage.setScene(scene);

        Canvas canvas = new Canvas(600,600);
        root.getChildren().add(canvas);

        ArrayList<String> input = new ArrayList<String>();

        scene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();
                    if(!input.contains(code))
                        input.add(code);
                }
        );

        scene.setOnKeyReleased(
                e -> {
                    String code = e.getCode().toString();
                    input.remove(code);
                }
        );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 24);
        gc.setFont(theFont);
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        Sprite briefcase = new Sprite();
        briefcase.setImage("images/briefcase.png");
        briefcase.setPosition(200,0);

        ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();

        for (int i = 0; i < 15; i++){
            Sprite moneybag = new Sprite();
            moneybag.setImage("images/moneybag.png");
            double x = 350 * Math.random() + 50;
            double y = 350 * Math.random() + 50;
            moneybag.setPosition(x,y);
            moneybagList.add(moneybag);
        }

        LongValue lastNanoTime = new LongValue(System.nanoTime());

        IntValue score = new IntValue(0);

        new AnimationTimer(){
            public void handle(long currentNanoTime){
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;

                briefcase.setVelocity(0,0);
                if(input.contains("LEFT"))
                    briefcase.addVelocity(-50,0);
                if(input.contains("RIGHT"))
                    briefcase.addVelocity(50,0);
                if(input.contains("UP"))
                    briefcase.addVelocity(0,-50);
                if(input.contains("DOWN"))
                    briefcase.addVelocity(0, 50);

                briefcase.update(elapsedTime);


                Iterator<Sprite> moneybagIter = moneybagList.iterator();
                while(moneybagIter.hasNext()){
                    Sprite moneybag = moneybagIter.next();
                    if(briefcase.intersects(moneybag)){
                        moneybagIter.remove();
                        score.value++;
                    }
                }

                gc.clearRect(0,0,600,600);
                briefcase.render(gc);

                for(Sprite moneybag : moneybagList)
                    moneybag.render(gc);

                String pointsText = "Cash: $" + (50 * score.value);
                gc.fillText(pointsText, 360,36);
                gc.strokeText(pointsText, 360,36);
            }
        }.start();

        theStage.show();
    }


}
