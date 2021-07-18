package Transition;

import View.Components.WildAnimal;
import javafx.animation.Transition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Locale;

public class WildAnimalAnimation extends AnimalAnimation {

    public static ArrayList<WildAnimalAnimation>allOfWildAnimalAnimations;

    private WildAnimal wildAnimal ;

    public WildAnimalAnimation(View.Components.WildAnimal wildAnimal){
        super(wildAnimal);
        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
        this.wildAnimal = wildAnimal ;

        System.out.println("Willldddd");
    }

    @Override
    protected void interpolate(double v) {
        super.interpolate(v);
    }



}
