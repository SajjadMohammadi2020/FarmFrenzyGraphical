package View.Components;


import View.main;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Animal extends Rectangle {

    public static double width = 40 ;
    public static double height  = 30 ;
    protected String name ;
    protected int life ;
    protected double speed ;

    Animal(){
        super(width,height);
        Random random = new Random() ;
        int x = random.nextInt((int)( main.sceneWidth-width));
        int y = random.nextInt((int)( main.sceneHeight - height ) );
        this.setLayoutX((double) x);
        this.setLayoutY((double) y);
    }

    public void setBackground(String url){
        this.setFill(new ImagePattern(new Image(url)));
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
