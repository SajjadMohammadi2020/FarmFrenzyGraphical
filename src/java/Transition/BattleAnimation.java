package Transition;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.*;

public class BattleAnimation extends Transition {

    public Rectangle rectangle ;
    public static int width = 80 ;
    public static int height = 80 ;
    public static int number = 5 ;
    public static int pics = 20 ;
    public Pane pane ;
    BattleAnimation(double x , double y , Pane pane){
        this.rectangle = new Rectangle(x,y,width,height);
        this.pane = pane ;
        this.pane.getChildren().add(rectangle);
        setCycleCount(number);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int)Math.floor(v*pics);
        frame++ ;
        System.out.println(frame);
        String str = "" ;
        if(frame<10){
            str += "0" ;
        }
        if(frame<=20) {
            String url = "/Sample/pictures/battle/image_part_0" + str + frame + ".png";
            System.out.println(url);
            this.rectangle.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
        }
    }
}
