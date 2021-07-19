package Transition;

import View.Components.WildAnimal;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Locale;

public class WildAnimalAnimation extends AnimalAnimation {

    public static ArrayList<WildAnimalAnimation>allOfWildAnimalAnimations;

    private WildAnimal wildAnimal ;
    public Pane pane ;

    public WildAnimalAnimation(View.Components.WildAnimal wildAnimal , Pane pane){
        super(wildAnimal);
        this.pane = pane ;
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
        this.wildAnimal = wildAnimal ;
        this.wildAnimal.wildAnimalAnimation = this ;
    }

    @Override
    protected void interpolate(double v) {
        super.interpolate(v);
        wildAnimal.cage.setWidth(2*wildAnimal.getWidth());
        wildAnimal.cage.setHeight(2*wildAnimal.getHeight());
        wildAnimal.cage.setLayoutX(wildAnimal.getLayoutX()-wildAnimal.getWidth()/2);
        wildAnimal.cage.setLayoutY(wildAnimal.getLayoutY()-wildAnimal.getHeight()/2);

    }


}
