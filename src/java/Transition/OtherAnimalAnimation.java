package Transition;

import View.Components.DomesticAnimalProduct;
import View.Components.OtherAnimal;
import View.Components.WildAnimal;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

public class OtherAnimalAnimation extends AnimalAnimation {

    public static ArrayList<OtherAnimalAnimation>allOtherAnimations;

    private View.Components.OtherAnimal otherAnimal ;
    public Pane pane ;

    public OtherAnimalAnimation(OtherAnimal animal , Pane pane ){
        super(animal);
        this.otherAnimal = animal ;
        this.pane = pane ;
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        super.interpolate(v);
        if(otherAnimal.getName().equals("cat")){
            collectProduct();
        } else if(otherAnimal.getName().equals("dog")){
            hasCollisionWilds();
        }
    }

    public void hasCollisionWilds(){
        for (int i = 0; i < WildAnimal.allWildAnimals.size(); i++) {
            if(AnimalAnimation.hasCollision(otherAnimal,WildAnimal.allWildAnimals.get(i))){
                BattleAnimation animation = new BattleAnimation(otherAnimal.getLayoutX(),otherAnimal.getLayoutY(),pane);
                WildAnimal.allWildAnimals.get(i).wildAnimalAnimation.stop();
                pane.getChildren().remove(WildAnimal.allWildAnimals.get(i));
                WildAnimal.allWildAnimals.remove(i);
                animation.play();
                pane.getChildren().remove(otherAnimal);
                break;
            }
        }
    }

    public void collectProduct(){
        for (int i = 0; i < DomesticAnimalProduct.allDomesticAnimalProducts.size(); i++) {
            if (otherAnimal.intersects(DomesticAnimalProduct.allDomesticAnimalProducts.get(i).getLayoutBounds())) {
                DomesticAnimalProduct.allDomesticAnimalProducts.get(i).life=0;
                System.out.println("collect");
                break;
            }
        }
    }




}
