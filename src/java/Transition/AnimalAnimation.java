package Transition;

import View.Components.Animal;
import javafx.animation.Transition;

import java.util.ArrayList;

public class AnimalAnimation extends Transition {
    public static ArrayList<AnimalAnimation>allAnimalAnimation = new ArrayList<AnimalAnimation>();

    private Animal animal ;

    AnimalAnimation(Animal animal){
        this.animal = animal ;
    }

    @Override
    protected void interpolate(double v) {

    }
}
