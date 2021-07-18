package View.Components;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Locale;

public class DomesticAnimal extends Animal{

    public static ArrayList<DomesticAnimal>allDomesticAnimals = new ArrayList<>() ;


    //اعداد ثابت مورد نیاز مرغ
    public static final int henBuyPrice = 100 ;
    public static final int henSellPrice = 80 ;
    public static final int henLife = 100 ;
    public static final int henProductTime = 15 ;
    public static final String henProduct = "egg" ;

    //اعداد ثابت مورد نیاز بوقلمون
    public static final int turkeyBuyPrice = 200 ;
    public static final int turkeySellPrice = 160 ;
    public static final int turkeyLife = 100 ;
    public static final int turkeyProductTime = 20 ;
    public static final String turkeyProduct = "feather" ;

    //اعداد ثابت مورد نیاز بوفالو
    public static final int buffaloBuyPrice = 300 ;
    public static final int buffaloSellPrice = 240 ;
    public static final int buffaloLife = 100 ;
    public static final int buffaloProductTime = 25 ;
    public static final String buffaloProduct = "milk" ;

    public static final double lowSpeed  = 2 ;
    public static final double fastSpeed = 4 ;

    public int sellPrice ;
    public int buyPrice ;
    public int productTime ;
    public String product ;
    public double max_speed ;
    public Rectangle picture ;
    public int eat ;
    public int death ;
    public Pane pane ;
    public ArrayList<DomesticAnimalProduct>products ;

    public DomesticAnimal(String name , Pane pane ){
        products = new ArrayList<>();
        this.pane = pane ;
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

    public void makeProduct(){
        DomesticAnimalProduct product = new DomesticAnimalProduct(this.getLayoutX(),this.getLayoutY(),this.product , pane);
        products.add(product) ;
    }

    public void setHen(){
        this.sellPrice = henSellPrice ;
        this.buyPrice = henBuyPrice ;
        this.productTime = henProductTime ;
        this.product = henProduct ;
        this.life = henLife ;
        this.speed = lowSpeed ;
        this.max_speed = fastSpeed ;
        this.up = 24 ;
        this.down = 24 ;
        this.left = 24 ;
        this.right = 24 ;
        this.up_right = 18 ;
        this.up_left = 24 ;
        this.down_left = 24 ;
        this.down_right = 24 ;
        this.eat = 24 ;
        this.death = 24 ;
    }

    public void setTurkey(){
        this.sellPrice = turkeySellPrice ;
        this.buyPrice = turkeyBuyPrice ;
        this.productTime = turkeyProductTime ;
        this.product = turkeyProduct ;
        this.life = turkeyLife ;
        this.speed = lowSpeed ;
        this.max_speed = fastSpeed ;
        this.up = 24 ;
        this.down = 24 ;
        this.left = 24 ;
        this.right = 24 ;
        this.up_right = 24 ;
        this.up_left = 24 ;
        this.down_left = 24 ;
        this.down_right = 24 ;
        this.eat = 24 ;
        this.death = 24 ;
    }

    public void setBuffalo(){
        this.sellPrice = buffaloSellPrice ;
        this.buyPrice = buffaloBuyPrice ;
        this.productTime = buffaloProductTime ;
        this.product = buffaloProduct ;
        this.life = buffaloLife ;
        this.speed = lowSpeed ;
        this.max_speed = fastSpeed ;
        this.up = 24 ;
        this.down = 24 ;
        this.left = 24 ;
        this.right = 24 ;
        this.up_right = 24 ;
        this.up_left = 24 ;
        this.down_left = 24 ;
        this.down_right = 24 ;
        this.eat = 22 ;
        this.death =30 ;
    }

    public void remove(){
        allDomesticAnimals.remove(this);
    }

}
