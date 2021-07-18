package View.Components;

import java.util.ArrayList;
import java.util.Locale;

public class OtherAnimal extends Animal{

    public static ArrayList<OtherAnimal> allOtherAnimals = new ArrayList<>();


    //اعداد ثابت مورد نیاز برای قیمت Cat و Dog
    public static final int catBuyPrice = 150 ;
    public static final int dogBuyPrice = 100 ;

    //متغیرهای این کلاس
    private int buyPrice ;


    public OtherAnimal(String name){
        this.name = name.toLowerCase(Locale.ROOT);
        this.life = 100 ;
        switch (this.name){
            case "cat" :
                setCat();
                break;
            case "dog" :
                setDog();
                break;
        }
        allOtherAnimals.add(this);
    }

    public void setCat(){
        this.buyPrice = catBuyPrice ;
    }

    public void setDog(){
        this.buyPrice = dogBuyPrice ;
    }

    public void remove(){
        allOtherAnimals.remove(this);
    }

}
