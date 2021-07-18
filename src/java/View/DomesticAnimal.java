package View;

import java.util.ArrayList;
import java.util.Random;

public class DomesticAnimal extends Animal{

    public static ArrayList<DomesticAnimal> allDomesticAnimals ;

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

    int sellPrice ;
    int buyPrice ;
    int productTime ;
    String product ;
    double max_speed ;
    double speed ;

    public static DomesticAnimal makeHen(){
        DomesticAnimal hen = new DomesticAnimal();
        hen.name = "hen" ;
        hen.sellPrice = henSellPrice ;
        hen.buyPrice = henBuyPrice ;
        hen.productTime = henProductTime ;
        hen.product = henProduct ;
        hen.life = henLife ;
        hen.speed = lowSpeed ;
        hen.max_speed = fastSpeed ;
        allDomesticAnimals.add(hen);
        return hen;
    }

    public static DomesticAnimal makeTurkey(){
        DomesticAnimal turkey = new DomesticAnimal();
        turkey.name = "turkey" ;
        turkey.sellPrice = turkeySellPrice ;
        turkey.buyPrice = turkeyBuyPrice ;
        turkey.productTime = turkeyProductTime ;
        turkey.product = turkeyProduct ;
        turkey.life = turkeyLife ;
        turkey.speed = lowSpeed ;
        turkey.max_speed = fastSpeed ;
        allDomesticAnimals.add(turkey);
        return turkey ;
    }

    public static DomesticAnimal makeBuffalo(){
        DomesticAnimal buffalo = new DomesticAnimal();
        buffalo.name = "buffalo" ;
        buffalo.sellPrice = buffaloSellPrice ;
        buffalo.buyPrice = buffaloBuyPrice ;
        buffalo.productTime = buffaloProductTime ;
        buffalo.product = buffaloProduct ;
        buffalo.life = buffaloLife ;
        buffalo.speed = lowSpeed ;
        buffalo.max_speed = fastSpeed ;
        allDomesticAnimals.add(buffalo);
        return buffalo ;
    }

    public void remove(){
        allDomesticAnimals.remove(this);
    }

    public boolean isHungry(){
        return this.life < 50 ;
    }

    public void feed(/*fooooooooooooooooood*/){
        this.life = 100 ;
        //remove fooooooood
    }

    public void move(){
//        if(isHungry()){
//            ///////////
//        }
        double[] newLoc = newLoc() ;
        while (!isAllowed(newLoc[0],newLoc[1])){
            newLoc = newLoc() ;
        }
        this.x = newLoc[0] ;
        this.y = newLoc[1];
        if(isHungry()){
            searchForFood();
            this.speed = fastSpeed ;
        } else {
            this.speed = lowSpeed ;
        }
        ///makeProduct
    }



    public boolean isAllowed(double x , double y ){
        boolean result = true ;
        if(hasDomesticAnimal(x,y)){
            result = false ;
        }
        if(OtherAnimal.hasOtherAnimal(x,y)){
            result = false ;
        }
        if(x>main.width || y > main.height || x < 0 || y < 0 ){
            result = false ;
        }
        return result ;
    }



    public static boolean hasDomesticAnimal(double x , double y ){
        for (int i = 0; i < allDomesticAnimals.size(); i++) {
            DomesticAnimal animal = allDomesticAnimals.get(i);
            if(animal.x==x&&animal.y==y){
                return true ;
            }
        }
        return false ;
    }

    public void searchForFood(){
//        for (int i = 0; i < Grass.allGrasses.size; i++) {
//            Grass grass = Grass.allGrasses.get(i);
//            if(this.x==grass.x){
//                feed(grass);
//                break;
//            }
//        }
    }

}
