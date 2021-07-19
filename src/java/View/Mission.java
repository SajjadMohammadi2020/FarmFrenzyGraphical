package View;

import Transition.AnimalAnimation;
import View.Components.Timer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Mission {

    //مقادیری که ماموریت های هر مرحله را تعیین میکند .
    public static final int max_level_number = 5; //تعداد کل مراحل
    public static final int coins_at_first[] = {1500,150,200,250,300};//تعداد سکه ها در ابتدای مرحله
    public static final int max_time_level[] = {0,120,140,160,180};//حداکثر زمان جایزه دار مرحله
    public static final int coins_for_reward[] = {0,50,70,90,110};//تعداد سکه های جایزه در صورت اتمام در زمان معین
    public static final int max_egg[] = {0,6,7,8,9} ; //تعداد تخم مرغ های مورد نیاز در هر مرحله
    public static final int max_feather[] = {0,3,4,5,6};//تعداد تخم پرهای مورد نیاز در هر مرحله
    public static final int max_milk[] = {0,2,3,4,5};//مقدار شیر مورد نیاز در هر مرحله
    public static final int max_egg_first_product[] = {0,5,6,7,8} ;//مقدار آرد در مورد نیاز در هر مرحله
    public static final int max_feather_first_product[] = {0,4,5,6,7} ;//مقدار پارچه مورد نیاز در هر مرحله
    public static final int max_milk_first_product [] = {0,3,4,5,6};//مقدار شیر پاکتی مورد نیاز در هر مرحله
    public static final int max_egg_second_product[] = {0,4,5,6,7} ;//مقدار نان مورد نیاز در هر مرحله
    public static final int max_feather_second_product[] = {0,4,5,6,7} ;//مقدار پیراهن مورد نیاز در هر مرحله
    public static final int max_milk_second_product [] = {0,3,4,5,6};//مقدار بستنی مورد نیاز در هر مرحله
    public static final int max_mission_coins[] = {0,160,170,180,190} ;//مقدار سکه مورد نیاز در هر مرحله
    public static final int max_hen [] = {3,5,6,7,8};//تعداد مرغ مورد نیاز هر مرحله
    public static final int max_turkey[] = {1,5,6,7,8} ;//تعداد بوقلمون مورد نیاز در هر مرحله
    public static final int max_buffalo[] = {0,4,5,6,7} ;//تعداد بوفالو مورد نیاز در هر مرحله
    public static final String wildAnimals[][][] = { { {"lion","2"} , {"lion","8"} }  ,  { {"lion","12" } , {"lion","23" } , {"lion","35"} } ,
            { {"lion","15"} , {"bear","24"} , {"lion" , "40"} } , { {"lion","15" } , { "bear","30" } , {"bear","50"}} ,
            { {"bear","15"} , {"lion","35"} , {"bear","50"}}};//حیوانات وحشی و زمان فرود آنها در هر مرحله


    //متغیر های این کلاس
    int levelNumber ;
    public static Levels[] levels ;
    public static Mission missionInstance ;

    public static Mission getMissionInstance(){
        if(missionInstance==null){
            missionInstance = new Mission();
        }
        return missionInstance ;
    }

    //کانستراکتور این کلاس
    private Mission(){
        //readFile();
        createNewMission();
    }

    //تابعی برای ایجاد ماموریت های مراحل جدید
    public void createNewMission(){
        this.levelNumber = max_level_number ;
        this.levels = new Levels[levelNumber] ;
        for (int i = 0; i < levelNumber; i++) {
            this.levels[i] = new Levels( coins_at_first[i],max_egg[i],max_feather[i],
                    max_milk[i],max_egg_first_product[i],max_feather_first_product[i],max_milk_first_product[i],
                    max_egg_second_product[i],max_feather_second_product[i],max_milk_second_product[i],
                    max_mission_coins[i],max_hen[i],max_turkey[i],max_buffalo[i],wildAnimals[i],max_time_level[i],
                    coins_for_reward[i] );
        }
        writeFile();
    }

    //تابعی برای نوشتن ذخیره ماموریت ها در فایل
    public void writeFile(){
        try {
            File file = new File("missions.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String js = gson.toJson(this.levelNumber)+"\n";
            fileWriter.write(js);
            String j = gson.toJson(this.levels);
            fileWriter.write(j);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //تابعی برای خواندن ماموریت ها از فایل
    public void readFile(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            File file = new File("missions.txt");
            file.createNewFile();
            ArrayList<String> lines = getLines(file);
            String level = lines.get(0);
            String obj = "" ;
            int j = 0 ;
            this.levelNumber = gson.fromJson(level,int.class);
            this.levels = new Levels[this.levelNumber];
            for (int i = 2; i < lines.size(); i++) {
                String x = lines.get(i);
                if(x.equals("[")||x.equals("]")){

                } else if (x.contains("  }")){
                    obj += "  }" ;
                    Levels level1 = gson.fromJson(obj, Levels.class);
                    this.levels[j] = level1 ; j++ ;
                    obj = "" ;
                }else {
                    obj += x ;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //تابعی برای گرفتن خطوط فایل جهت خواندن ماموریت ها
    public ArrayList<String> getLines(File file){
        ArrayList<String> result = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String x = myReader.nextLine();
                result.add(x);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result ;
    }

    public static void missionPage(){
        Pane pane = new Pane();
        HBox hBox = new HBox();
        hBox.setLayoutX(200);
        hBox.setLayoutY(100);
        hBox.setPrefWidth(400);
        hBox.setPrefHeight(600);
        hBox.getChildren().add(new Text("Your missions is : \n"));
        if(Mission.levels[main.level-1].max_egg!=0){ hBox.getChildren().add(new Text("Egg : " + Mission.levels[main.level-1].egg + " / " + Mission.levels[main.level-1].max_egg +"\n")); }
        if(Mission.levels[main.level-1].max_feather!=0){ hBox.getChildren().add(new Text("Feather : " + Mission.levels[main.level-1].feather + " / " + Mission.levels[main.level-1].max_feather +"\n")); }
        if(Mission.levels[main.level-1].max_milk!=0){ hBox.getChildren().add(new Text("Milk : " + Mission.levels[main.level-1].milk + " / " + Mission.levels[main.level-1].max_milk +"\n")); }
        if(Mission.levels[main.level-1].max_egg_first_product!=0){ hBox.getChildren().add(new Text("Flour : " + Mission.levels[main.level-1].egg_first_product + " / " + Mission.levels[main.level-1].max_egg_first_product+"\n" )); }
        if(Mission.levels[main.level-1].max_feather_first_product!=0){ hBox.getChildren().add(new Text("Fabric : " + Mission.levels[main.level-1].feather_first_product + " / " +Mission.levels[main.level-1].max_feather_first_product+"\n" )); }
        if(Mission.levels[main.level-1].max_milk_first_product!=0){ hBox.getChildren().add(new Text("PackedMilk : " + Mission.levels[main.level-1].milk_first_product + " / " +Mission.levels[main.level-1].max_milk_first_product+"\n" )); }
        if(Mission.levels[main.level-1].max_egg_second_product!=0){ hBox.getChildren().add(new Text("Bread : " + Mission.levels[main.level-1].egg_second_product + " / " + Mission.levels[main.level-1].max_egg_second_product+"\n" )); }
        if(Mission.levels[main.level-1].max_feather_second_product!=0){ hBox.getChildren().add(new Text("Cloth : " + Mission.levels[main.level-1].feather_second_product + " / " + Mission.levels[main.level-1].max_feather_second_product+"\n" )); }
        if(Mission.levels[main.level-1].max_milk_second_product!=0){ hBox.getChildren().add(new Text("Ice cream : " + Mission.levels[main.level-1].milk_second_product + " / " +Mission.levels[main.level-1].max_milk_second_product +"\n")); }
        if(Mission.levels[main.level-1].max_hen!=0){ hBox.getChildren().add(new Text("Hen : " + Mission.levels[main.level-1].hen + " / " + Mission.levels[main.level-1].max_hen +"\n")); }
        if(Mission.levels[main.level-1].max_turkey!=0){ hBox.getChildren().add(new Text("Turkey : " + Mission.levels[main.level-1].turkey + " / " + Mission.levels[main.level-1].max_turkey+"\n" )); }
        if(Mission.levels[main.level-1].max_buffalo!=0){ hBox.getChildren().add(new Text("Buffalo : " + Mission.levels[main.level-1].buffalo + " / " + Mission.levels[main.level-1].max_buffalo +"\n")); }
        if(Mission.levels[main.level-1].max_mission_coins!=0){ hBox.getChildren().add(new Text("Coin : " + Mission.levels[main.level-1].coins + " / " + Mission.levels[main.level-1].max_mission_coins +"\n")); }
        pane.getChildren().add(hBox);
        Button button = new Button();
        Scene old = main.stage.getScene() ;
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for (int i = 0; i < AnimalAnimation.allAnimalAnimation.size(); i++) {
                    AnimalAnimation.allAnimalAnimation.get(i).play();
                }
                Timer.getTimerInstance(pane,main.level).play();
                main.stage.setScene(old);
            }
        });
        button.setText("OK");
        pane.getChildren().add(button);
        Scene scene = new Scene(pane,600,600);
        main.stage.setScene(scene);
    }


}

