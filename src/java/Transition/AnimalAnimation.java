package Transition;

import View.Components.Animal;
import javafx.animation.Transition;
import javafx.util.Duration;

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

}
