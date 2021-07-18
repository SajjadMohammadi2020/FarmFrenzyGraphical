package View;

import java.util.ArrayList;

public class WildAnimal extends Animal{
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
    private int sellPrice ;
    private int speed ;
    private boolean caged ;
    public static ArrayList<WildAnimal> allWildAnimals;

    public static WildAnimal makeLion(){
        WildAnimal lion = new WildAnimal();
        lion.name = "lion" ;
        lion.speed = lionSpeed ;
        lion.life = lionLife ;
        lion.caged = false ;
        allWildAnimals.add(lion);
        return lion ;
    }

    public static WildAnimal makeBear(){
        WildAnimal bear = new WildAnimal();
        bear.name = "bear" ;
        bear.speed = bearSpeed ;
        bear.life = bearLife ;
        bear.caged = false ;
        allWildAnimals.add(bear);
        return bear ;
    }

    public static WildAnimal makeTiger(){
        WildAnimal tiger = new WildAnimal();
        tiger.name = "tiger" ;
        tiger.speed = tigerSpeed ;
        tiger.life = tigerLife ;
        tiger.caged = false ;
        allWildAnimals.add(tiger);
        return tiger ;
    }

    public void remove(){
        allWildAnimals.remove(this);
    }

    public static boolean hasWildAnimal(double x ,double y ){
        for (int i = 0; i < allWildAnimals.size(); i++) {
            WildAnimal animal = allWildAnimals.get(i);
            if(animal.x==x&&animal.y==y){
                return true ;
            }
        }
        return false ;
    }

}
