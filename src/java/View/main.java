package View;

import View.Components.Logo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.naming.LinkLoopException;
import java.util.Locale;
import java.util.Scanner;

public class main extends Application {
    public static int width = 6 ;
    public static int height = 6 ;
    public static double sceneHeight = 800 ;
    public static double sceneWidth = 800 ;
    public static int money = 1000 ;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(0,0,sceneWidth,sceneWidth);
        rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/pictures/back6.png").toExternalForm())));
        pane.getChildren().add(rectangle);
        Logo henLogo = new Logo("hen" , DomesticAnimal.henBuyPrice ) ;
        henLogo.add(pane);
        Logo turkeyLogo = new Logo("turkey" , DomesticAnimal.turkeyBuyPrice );
        turkeyLogo.add(pane);
        Logo buffaloLogo = new Logo("buffalo" , DomesticAnimal.buffaloBuyPrice );
        buffaloLogo.add(pane);
        Logo dogLogo = new Logo("dog" , OtherAnimal.dogBuyPrice );
        dogLogo.add(pane);
        Logo catLogo = new Logo("cat" , OtherAnimal.catBuyPrice );
        catLogo.add(pane);
        Scene scene = new Scene(pane,sceneWidth,sceneHeight) ;
        stage.setScene(scene);
        stage.setTitle("Farm Frenzy");

        stage.getIcons().add(new Image(getClass().getResource("/Sample/pictures/logo.png").toExternalForm()));
        stage.show();
    }


}
