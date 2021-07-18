package View.Components;

import java.util.ArrayList;
import java.util.Locale;

public class WildAnimal extends Animal{

    public static ArrayList<WildAnimal>allWildAnimals = new ArrayList<>();

    private int sellPrice ;

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
    private int speed ;
    private boolean caged ;


    public WildAnimal(String name){
        this.name = name.toLowerCase(Locale.ROOT) ;
        this.caged = false ;
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
    }

    public void  setLion(){
        this.speed = lionSpeed ;
        this.life = lionLife ;
        this.sellPrice = lionSellPrice ;
    }

    public void setBear(){
        this.speed = bearSpeed ;
        this.life = bearLife ;
        this.sellPrice = bearSellPrice ;
    }

    public void setTiger(){
        this.speed = tigerSpeed ;
        this.life = tigerLife ;
        this.sellPrice = tigerSellPrice ;
    }

    public void remove(){
        allWildAnimals.remove(this);
    }


}
