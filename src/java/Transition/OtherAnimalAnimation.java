package Transition;

import View.Components.OtherAnimal;
import javafx.animation.Transition;
import javafx.util.Duration;

import java.util.ArrayList;

public class OtherAnimalAnimation extends AnimalAnimation {

    public static ArrayList<OtherAnimalAnimation>allOtherAnimations;

    private View.Components.OtherAnimal otherAnimal ;

    OtherAnimalAnimation(OtherAnimal animal){
        super(animal);
        this.otherAnimal = animal ;
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {

    }
}
