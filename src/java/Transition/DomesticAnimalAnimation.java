package Transition;

import View.Components.DomesticAnimal;
import View.Components.DomesticAnimalProduct;
import View.main;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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
    private int times ;
    private boolean hasProduct = false ;

    public DomesticAnimalAnimation(View.Components.DomesticAnimal animal){
        super(animal);
        this.times = 0 ;
        this.animal = animal ;
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        super.interpolate(v);
        if(v==1){
            animal.life -= 5 ;
            times++ ;
            decreaseProductLife();
            if(hasProduct==true){
                hasProduct=false ;
            }
        }
        if(animal.life<=50){
            //eat grass
        }
        makeProduct();
        removeProducts();
    }

    public void makeProduct(){
        if(times%animal.productTime==0&&times!=0&&hasProduct==false){
            animal.makeProduct();
            hasProduct=true ;
            System.out.println("make");
        }
    }

    public void decreaseProductLife(){
        for (int i = 0; i < animal.products.size(); i++) {
            animal.products.get(i).life--;
        }
    }

    public void removeProducts(){
        boolean delete = false ;
        for (int i = 0; i < DomesticAnimalProduct.allDomesticAnimalProducts.size()&&(!delete); i++) {
            if(DomesticAnimalProduct.allDomesticAnimalProducts.get(i).life==0){
                DomesticAnimalProduct.allDomesticAnimalProducts.get(i).remove();
                DomesticAnimalProduct.allDomesticAnimalProducts.remove(i);
                delete = true ;
                break;
            }
        }
    }

}
