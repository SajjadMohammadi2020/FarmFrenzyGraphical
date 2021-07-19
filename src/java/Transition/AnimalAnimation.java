package Transition;

import View.Components.Animal;
import javafx.animation.Transition;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AnimalAnimation extends Transition {
    public static ArrayList<AnimalAnimation>allAnimalAnimation = new ArrayList<AnimalAnimation>();

    protected Animal animal ;
    protected int theta ;

    public AnimalAnimation(Animal animal){
        this.animal = animal ;
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
        Random random = new Random();
        theta = random.nextInt(360);
    }

    @Override
    protected void interpolate(double v) {
        double dx = animal.getSpeed()*Math.cos(Math.toRadians(theta));
        double dy = animal.getSpeed()*Math.sin(Math.toRadians(theta));
        theta = theta % 360 ;
        if(theta<0){
            theta+=360 ;
        }
        int frame = 0 ;
        int x = 0 ;
        String url = "/Sample/pictures/"+animal.getName()+"/" ;
        if((theta>=0&&theta<=10)||(theta<360&&theta>=350)){
            //right
            x = animal.right ;
            url += "right" ;
            animal.move(dx,dy);
        } else if(theta>10&&theta<80) {
            //up_right
            x = animal.up_right ;
            url += "up_right" ;
            animal.move(dx,(double) -1.0*dy );
        } else if(theta>=80&&theta<=100){
            //up
            x = animal.up ;
            url += "up" ;
            animal.move(dx,(double)-1* dy);
        } else if(theta>100&&theta<170){
            //up_left
            x = animal.up_left ;
            url += "up_left" ;
            animal.move(dx,(double) -1.0*dy );
        } else if (theta>=170&&theta<=190){
            //left
            x = animal.left ;
            url += "left" ;
            animal.move(dx,dy);
        } else if (theta>190&&theta<260){
            //down_left
            x = animal.down_left ;
            url += "down_left" ;
            animal.move(dx,(double) -1.0*dy );
        } else if(theta>=260&&theta<=280){
            //down
            x = animal.down ;
            url += "down" ;
            animal.move(dx,(double) -1.0*dy );
        } else if(theta>280&&theta<350){
            //down_right
            x = animal.down_right ;
            url += "down_right" ;
            animal.move(dx,(double) -1.0*dy );
        }
        frame = (int)Math.floor(v*x);
        frame ++ ;
        String str = "" ;
        if(frame<10){
            str += "0" ;
        }
        url += "/image_part_0"+ str+ frame + ".png" ;
        if(frame<=x){
        animal.setBackground(url);
        }
        hitFloor();
        hitLeft();
        hitRight();
        hitTop();
    }

    public void hitTop(){
        if(animal.getLayoutY()<=Animal.up_height){
            theta = getRandomTheta() + 180 ;
            animal.setLayoutY(Animal.up_height+2);
        }
    }

    public void hitFloor(){
        if(animal.getLayoutY()+animal.getHeight()>=Animal.down_height){
            theta = getRandomTheta() ;
            animal.setLayoutY(Animal.down_height-animal.getHeight()-2);
        }
    }

    public void hitRight(){
        if(animal.getLayoutX()+animal.getWidth()>=Animal.right_width){
            theta = getRandomTheta() + 90 ;
            animal.setLayoutX(Animal.right_width-animal.getWidth()-animal.getSpeed());
        }
    }

    public void hitLeft(){
        if(animal.getLayoutX()<=Animal.left_width){
            theta = getRandomTheta() - 90 ;
            animal.setLayoutX(Animal.left_width+2);
        }
    }

    public int getRandomTheta(){
        Random random = new Random();
        int degree = random.nextInt(180) ;
        return degree ;
    }

    public static boolean hasCollision(javafx.scene.shape.Rectangle rectangle1 , javafx.scene.shape.Rectangle rectangle2 ){
        return hasTopCollision(rectangle1,rectangle2) || hasLeftCollision(rectangle1,rectangle2) ||
                hasRightCollision(rectangle1,rectangle2) || hasBottomCollision(rectangle1,rectangle2) ;
    }

    public static boolean hasTopCollision(javafx.scene.shape.Rectangle rectangle1 , javafx.scene.shape.Rectangle rectangle2){
        boolean a = rectangle1.getLayoutY()+rectangle1.getHeight() >= rectangle2.getLayoutY() ;
        boolean b = rectangle1.getLayoutX() > rectangle2.getLayoutX()+rectangle2.getWidth();
        boolean c = rectangle1.getLayoutX()+rectangle1.getWidth()<rectangle2.getLayoutX() ;
        if(a&&!b&&!c){
            return true ;
        } else {
            return false ;
        }
    }

    public static boolean hasLeftCollision(javafx.scene.shape.Rectangle rectangle1 , javafx.scene.shape.Rectangle rectangle2){
        boolean a = rectangle1.getLayoutX() + rectangle1.getWidth() >= rectangle2.getLayoutX() ;
        boolean b = rectangle1.getLayoutY() > rectangle2.getLayoutY() + rectangle2.getHeight() ;
        boolean c = rectangle1.getLayoutY()+rectangle1.getHeight() < rectangle2.getLayoutY() ;
        if(a&&!b&&!c){
            return true ;
        } else {
            return false;
        }
    }

    public static boolean hasRightCollision(javafx.scene.shape.Rectangle rectangle1 ,javafx.scene.shape.Rectangle rectangle2){
        boolean a = rectangle1.getLayoutX() <= rectangle2.getLayoutX() + rectangle2.getWidth() ;
        boolean b = rectangle1.getLayoutY() > rectangle2.getLayoutY() + rectangle2.getHeight() ;
        boolean c = rectangle1.getLayoutY()+rectangle1.getHeight() < rectangle2.getLayoutY() ;
        if(a&&!b&&!c){
            return true ;
        } else {
            return false;
        }
    }

    public static boolean hasBottomCollision(javafx.scene.shape.Rectangle rectangle1 ,javafx.scene.shape.Rectangle rectangle2){
        System.out.println("x:"+rectangle1.getX());
        System.out.println("x:"+rectangle2.getX());
        boolean a = rectangle1.getLayoutY() <= rectangle2.getLayoutY()+rectangle2.getHeight();
        boolean b = rectangle1.getLayoutX() > rectangle2.getLayoutX()+rectangle2.getWidth();
        boolean c = rectangle1.getLayoutX()+rectangle1.getWidth()<rectangle2.getLayoutX() ;
        if(a&&!b&&!c){
            return true ;
        } else {
            return false ;
        }
    }

}
