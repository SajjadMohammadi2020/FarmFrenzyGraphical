package View.Components;


import View.main;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Animal extends Rectangle {

    public static double width = 100 ;
    public static double height  = 70 ;
    protected String name ;
    public int life ;
    protected double speed ;
    public int up ;
    public int down ;
    public int left ;
    public int right ;
    public int up_right ;
    public int down_right ;
    public int up_left ;
    public int down_left ;

    public static int up_height = 200 ;
    public static int down_height = (int)main.sceneHeight - 200 ;
    public static int left_width = 200 ;
    public static int right_width = (int)main.sceneWidth - 200 ;

    Animal(){
        super(width,height);
        Random random = new Random() ;
        int x = random.nextInt((int)( main.sceneWidth-width));
        int y = random.nextInt((int)( main.sceneHeight - height ) );
        while (x<left_width||(x+width)>right_width||y<up_height||(y+height)>down_height){
            x = random.nextInt((int)( main.sceneWidth-width));
            y = random.nextInt((int)( main.sceneHeight - height ) );
        }
        this.setLayoutX((double) x);
        this.setLayoutY((double) y);
    }

    public void setBackground(String url){
        this.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
    }

    public void move(double dx , double dy){
        this.setLayoutX(this.getLayoutX()+dx);
        this.setLayoutY(this.getLayoutY()+dy);
    }


    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public double getSpeed() {
        return speed;
    }
}
