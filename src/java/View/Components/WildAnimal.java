package View.Components;

import Transition.WildAnimalAnimation;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Locale;

public class WildAnimal extends Animal{

    public static ArrayList<WildAnimal>allWildAnimals = new ArrayList<>();

    private int sellPrice ;

    public static int[] timeStart = {10,20};
    public static String[] nameStart = {"lion" , "bear"} ;


    //مقادیر ثابت مورد نیاز خرس
    public static final int bearSpeed = 1 ;
    public static final int bearLife = 4 ;
    public static final int bearSellPrice = 400 ;

    //مقادیر ثابت مورد نیاز شیر
    public static final int lionSpeed = 1 ;
    public static final int lionLife = 3 ;
    public static final int lionSellPrice = 300 ;

    //مقادیر مورد نیاز ببر
    public static final int tigerSpeed = 2 ;
    public static final int tigerLife = 4 ;
    public static final int tigerSellPrice = 500 ;

    //متغیرهای موجود در این کلاس
    private boolean caged ;
    public double lowSpeed ;
    public int numberCaged ;
    public Rectangle cage ;
    public Pane pane ;
    public WildAnimalAnimation wildAnimalAnimation ;

    public WildAnimal(String name , Pane pane ){
        cage = new Rectangle() ;

        String url = "/Sample/pictures/cage/image_part_001.png" ;
        cage.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
        this.pane = pane ;
        this.numberCaged = 0 ;
        this.speed = lowSpeed ;
        this.name = name.toLowerCase(Locale.ROOT) ;
        this.caged = false ;
        this.pane.getChildren().add(this);
        this.pane.getChildren().add(cage);
        switch (this.name){
            case "lion" :
                setLion();
                break;
            case "bear" :
                setBear();
                break;
            case "tiger" :
                setTiger();
                break;
        }
        allWildAnimals.add(this);
        this.cage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(numberCaged<8) {
                    numberCaged++;
                    String url = "/Sample/pictures/cage/image_part_00" + (numberCaged + 1)+".png";
                    cage.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
                    WildAnimal.this.speed -= (double)lionSpeed/8 ;
                    if(numberCaged==8){
                        caged = true ;
                    }
                } else {
                    pane.getChildren().remove(WildAnimal.this);
                    pane.getChildren().remove(WildAnimal.this.cage);
                    allWildAnimals.remove(WildAnimal.this);
                }
            }
        });
    }

    public void  setLion(){
        this.speed = lionSpeed ;
        this.life = lionLife ;
        this.sellPrice = lionSellPrice ;
        this.up = 24 ;
        this.down = 24 ;
        this.left = 24 ;
        this.right = 24 ;
        this.up_right = 24 ;
        this.up_left = 24 ;
        this.down_left = 24 ;
        this.down_right = 24 ;
    }

    public void setBear(){
        this.speed = bearSpeed ;
        this.life = bearLife ;
        this.sellPrice = bearSellPrice ;
        this.up = 24 ;
        this.down = 24 ;
        this.left = 24 ;
        this.right = 24 ;
        this.up_right = 24 ;
        this.up_left = 24 ;
        this.down_left = 24 ;
        this.down_right = 24 ;
    }

    public void setTiger(){
        this.speed = tigerSpeed ;
        this.life = tigerLife ;
        this.sellPrice = tigerSellPrice ;
        this.up = 24 ;
        this.down = 24 ;
        this.left = 24 ;
        this.right = 24 ;
        this.up_right = 24 ;
        this.up_left = 24 ;
        this.down_left = 24 ;
        this.down_right = 24 ;
    }

    public void remove(){
        allWildAnimals.remove(this);
    }

    
}
