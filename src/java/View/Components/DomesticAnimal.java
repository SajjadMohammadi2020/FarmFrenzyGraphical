package View.Components;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Locale;

public class DomesticAnimal extends Animal{

    public static ArrayList<DomesticAnimal>allDomesticAnimals = new ArrayList<>() ;


    //اعداد ثابت مورد نیاز مرغ
    public static final int henBuyPrice = 100 ;
    public static final int henSellPrice = 80 ;
    public static final int henLife = 100 ;
    public static final int henProductTime = 2 ;
    public static final String henProduct = "egg" ;

    //اعداد ثابت مورد نیاز بوقلمون
    public static final int turkeyBuyPrice = 200 ;
    public static final int turkeySellPrice = 160 ;
    public static final int turkeyLife = 100 ;
    public static final int turkeyProductTime = 3 ;
    public static final String turkeyProduct = "feather" ;

    //اعداد ثابت مورد نیاز بوفالو
    public static final int buffaloBuyPrice = 300 ;
    public static final int buffaloSellPrice = 240 ;
    public static final int buffaloLife = 100 ;
    public static final int buffaloProductTime = 5 ;
    public static final String buffaloProduct = "milk" ;

    public static final double lowSpeed  = 1 ;
    public static final double fastSpeed = 2 ;

    private int sellPrice ;
    private int buyPrice ;
    private int productTime ;
    private String product ;
    private double max_speed ;
    private double speed ;
    private Rectangle picture ;

    public DomesticAnimal(String name){
        this.name = name.toLowerCase(Locale.ROOT);
        switch (this.name){
            case "hen" :
                setHen();
                break;
            case "turkey" :
                setTurkey();
                break;
            case "buffalo" :
                setBuffalo();
                break;
        }
        allDomesticAnimals.add(this);
    }

    public void setHen(){
        this.sellPrice = henSellPrice ;
        this.buyPrice = henBuyPrice ;
        this.productTime = henProductTime ;
        this.product = henProduct ;
        this.life = henLife ;
        this.speed = lowSpeed ;
        this.max_speed = fastSpeed ;
    }

    public void setTurkey(){
        this.sellPrice = turkeySellPrice ;
        this.buyPrice = turkeyBuyPrice ;
        this.productTime = turkeyProductTime ;
        this.product = turkeyProduct ;
        this.life = turkeyLife ;
        this.speed = lowSpeed ;
        this.max_speed = fastSpeed ;
    }

    public void setBuffalo(){
        this.sellPrice = buffaloSellPrice ;
        this.buyPrice = buffaloBuyPrice ;
        this.productTime = buffaloProductTime ;
        this.product = buffaloProduct ;
        this.life = buffaloLife ;
        this.speed = lowSpeed ;
        this.max_speed = fastSpeed ;
    }

    public void remove(){
        allDomesticAnimals.remove(this);
    }

}
