package View.Components;

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


    public WildAnimal(String name){
        this.speed = lowSpeed ;
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
        System.out.println("wiiillllllllllddd");
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
