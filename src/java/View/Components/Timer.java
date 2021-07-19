package View.Components;

import View.Mission;
import View.main;
import javafx.animation.Transition;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import Transition.WildAnimalAnimation ;
import java.awt.*;
import java.time.Instant;

public class Timer extends Transition {

    public static Timer timerInstance ;
    public static long endTime ;
    public int level ;

    public static Timer getTimerInstance(Pane pane , int level ){
        if(timerInstance==null){
            timerInstance = new Timer(pane , level );
        }
        return timerInstance ;
    }

    public Button button ;
    private Text text ;
    private Pane pane ;

    private Timer(Pane pane , int level){
        this.level = level ;
        this.pane = pane ;
        this.button = new Button();
        this.button.setLayoutX(main.sceneWidth-85);
        this.button.setLayoutY(main.sceneHeight-30);
        this.pane.getChildren().add(button);
        this.text = new Text();
        button.setText(text.getText());
        this.pane.getChildren().add(text);
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        endTime = Instant.now().toEpochMilli();
        int duration = (int) (endTime - main.timeStart) ;
        duration /= 1000 ;
        if(v==1){
        getWildAnimal(duration);}
        int  minute = duration / 60 ;
        int second = duration % 60 ;
        text.setText("Time : " + minute+" : "+second);
        button();
        button.setText(text.getText());
        removeProducts();
    }

    private void button(){
        pane.getChildren().remove(button);
        this.button = new Button();
        this.button.setLayoutX(main.sceneWidth-85);
        this.button.setLayoutY(main.sceneHeight-30);
        this.pane.getChildren().add(button);
    }

    public void getWildAnimal(int duration){
        for (int i = 0; i < Mission.getMissionInstance().levels[level-1].wildAnimals.length; i++) {
            int time = Integer.parseInt(Mission.getMissionInstance().levels[level-1].wildAnimals[i][1]);
            //System.out.println(time);
            if(duration==time){
                System.out.println(time);
                String name = Mission.getMissionInstance().levels[level-1].wildAnimals[i][0];
                WildAnimal animal = new WildAnimal(name,pane);
                WildAnimalAnimation animation = new WildAnimalAnimation(animal,pane);
                animation.play();
            }
        }
    }

    public void removeProducts(){
        for (int i = 0; i < DomesticAnimalProduct.allDomesticAnimalProducts.size(); i++) {
            if(DomesticAnimalProduct.allDomesticAnimalProducts.get(i).life==0){
                pane.getChildren().remove(DomesticAnimalProduct.allDomesticAnimalProducts.get(i));
                DomesticAnimalProduct.allDomesticAnimalProducts.remove(i);
            }
        }
    }



}
