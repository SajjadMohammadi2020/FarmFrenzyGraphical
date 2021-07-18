package View;

import java.util.ArrayList;
import java.util.Locale;

public class OtherAnimal extends Animal{

    public static ArrayList<OtherAnimal> allOtherAnimals;

    //اعداد ثابت مورد نیاز برای قیمت Cat و Dog
    public static final int catBuyPrice = 150 ;
    public static final int dogBuyPrice = 100 ;

    //متغیرهای این کلاس
    int buyPrice ;

    public static OtherAnimal makeCat(){
        OtherAnimal cat = new OtherAnimal();
        cat.name = "cat" ;
        cat.buyPrice = catBuyPrice ;
        cat.life = 100 ;
        allOtherAnimals.add(cat);
        return cat ;
    }

    private OtherAnimal makeDog(){
        OtherAnimal dog = new OtherAnimal();
        dog.name = "dog" ;
        dog.buyPrice = dogBuyPrice ;
        dog.life = 100 ;
        allOtherAnimals.add(dog);
        return dog ;
    }

    public void remove(){
        allOtherAnimals.remove(this);
    }

    public static boolean hasOtherAnimal(double x ,double  y ){
        for (int i = 0; i < allOtherAnimals.size(); i++) {
            OtherAnimal animal = allOtherAnimals.get(i);
            if(animal.x==x&&animal.y==y){
                return true ;
            }
        }
        return false ;
    }

}
