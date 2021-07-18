package Transition;

import View.Components.DomesticAnimal;
import View.main;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class DomesticAnimalAnimation extends AnimalAnimation {


    public static ArrayList<DomesticAnimalAnimation> allDomesticAnimations ;
    public static int rightPics = 5 ;
    public static int leftPics = 5 ;
    public static int topPics = 5 ;
    public static int bottomPics = 5 ;


    private DomesticAnimal animal ;
    private int numberOfPics ;
    private double theta ;

    DomesticAnimalAnimation(View.Components.DomesticAnimal animal){
        super(animal);
        this.animal = animal ;
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        move();
        setPic(v);
        hitFloor();
        hitLeft();
        hitRight();
        hitTop();
    }

    public void  move(){
        double dx = animal.getSpeed() * Math.cos(Math.toRadians(theta));
        double dy = animal.getSpeed() * Math.sin(Math.toRadians(theta));
        animal.move(dx,dy);
    }

    public void setPic(double v ){
        double degree = theta % 360 ;
        String address = getClass().getResource("/Sample/pictures/").toExternalForm();
        String picHint = "" ;
        int frame = 0 ;
        if( (degree>=0&&degree<=85) || (degree>=275&&degree<360) ){
            frame = (int)Math.floor(v*rightPics);
            picHint = "r" ;
        } else if ( (degree>=95&&degree<=265)){
            frame = (int)Math.floor(v*leftPics);
            picHint = "l" ;
        } else if (degree>265&&degree<275){
            frame = (int)Math.floor(v*bottomPics);
            picHint = "b" ;
        } else if (degree>85&&degree<95){
            frame = (int)Math.floor(v*topPics);
            picHint = "t" ;
        }
        animal.setBackground(address+picHint+frame+".png");
    }

    public void hitRight(){
        if(animal.getLayoutX()+animal.getWidth()>= main.sceneWidth){
            Random random = new Random();
            int degree = random.nextInt(180);
            theta = degree - 90 ;
        }
    }

    public void hitLeft(){
        if(animal.getLayoutX()<=0){
            Random random = new Random();
            int degree = random.nextInt(180) ;
            theta = degree + 90 ;
        }
    }

    public void hitTop(){
        if(animal.getLayoutY()<=0){
            Random random = new Random();
            int degree = random.nextInt(180);
            theta = degree + 180 ;
        }
    }

    public void hitFloor(){
        if(animal.getLayoutY()+animal.getHeight()>=main.sceneHeight){
            Random random = new Random();
            int degree = random.nextInt(180) ;
            theta = degree ;
        }
    }


}
