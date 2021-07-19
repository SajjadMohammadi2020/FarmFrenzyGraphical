package View;

import Transition.AnimalAnimation;
import View.Components.DomesticAnimal;
import View.Components.Logo;
import View.Components.OtherAnimal;
import View.Components.Timer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.naming.LinkLoopException;
import java.time.Instant;
import java.util.Locale;
import java.util.Scanner;

public class main extends Application {
    public static int width = 6 ;
    public static int height = 6 ;
    public static double sceneHeight = 800 ;
    public static double sceneWidth = 800 ;
    public static int money = 1000 ;
    public static long timeStart ;
    public static long timeEnd ;
    public static int level = 1 ;
    public static Stage stage ;

    public static void main(String[] args) {
        timeStart = Instant.now().toEpochMilli() ;
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        main.stage = stage ;
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(0,0,sceneWidth,sceneWidth);
        rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/pictures/back6.png").toExternalForm())));
        pane.getChildren().add(rectangle);
        Timer timer = Timer.getTimerInstance(pane , level) ;
        timer.play();
        Button button = button(pane);
        button.setLayoutX(timer.button.getLayoutX()-50);
        button.setLayoutY(timer.button.getLayoutY());
        pane.getChildren().add(button);
        Logo henLogo = new Logo("hen" , DomesticAnimal.henBuyPrice , pane ) ;
        henLogo.add(pane);
        Logo turkeyLogo = new Logo("turkey" , DomesticAnimal.turkeyBuyPrice , pane );
        turkeyLogo.add(pane);
        Logo buffaloLogo = new Logo("buffalo" , DomesticAnimal.buffaloBuyPrice,pane );
        buffaloLogo.add(pane);
        Logo dogLogo = new Logo("dog" , OtherAnimal.dogBuyPrice,pane );
        dogLogo.add(pane);
        Logo catLogo = new Logo("cat" , OtherAnimal.catBuyPrice,pane );
        catLogo.add(pane);
        Scene scene = new Scene(pane,sceneWidth,sceneHeight) ;
        stage.setScene(scene);
        stage.setTitle("Farm Frenzy");
        stage.getIcons().add(new Image(getClass().getResource("/Sample/pictures/logo.png").toExternalForm()));
        stage.show();
    }

    public Button button(Pane pane){
        Button button = new Button();
        button.setText("tasks");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for (int i = 0; i < AnimalAnimation.allAnimalAnimation.size(); i++) {
                    AnimalAnimation.allAnimalAnimation.get(i).pause();
                }
                Timer.getTimerInstance(pane,level).pause();
               Mission.missionPage();
            }
        });
        return button ;
    }

}

