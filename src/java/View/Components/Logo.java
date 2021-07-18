package View.Components;

import View.main;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.Locale;

public class Logo extends Shape {

    public static double logoRadius = 30 ;
    public static double dLogoRadius = 5 ;

    private String name ;
    private Circle circle1  ;
    private Circle circle2  ;
    private int price ;
    private Circle picture ;
    private Button button ;


    public Logo(String name , int price ){
        name = name.toLowerCase(Locale.ROOT);
        this.name = name ;
        this.price = price ;
        this.picture = setPicture(name);
        this.circle1 = setCircle(1);
        this.circle2 = setCircle(2);
        this.button = setButton();
    }

    private Circle setPicture(String name){
        Circle logo = new Circle() ;
        name = name.toLowerCase(Locale.ROOT);
        logo.setCenterY(dLogoRadius+logoRadius);
        logo.setRadius(logoRadius);
        logo.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/pictures/logo/"+name+"Logo.png").toExternalForm())));
        switch (name){
            case "hen" :
                logo.setCenterX(dLogoRadius+logoRadius);
                break;
            case "turkey" :
                logo.setCenterX(3*(dLogoRadius+logoRadius));
                break;
            case "buffalo" :
                logo.setCenterX((5*(dLogoRadius+logoRadius)));
                break;
            case "dog" :
                logo.setCenterX(7*(dLogoRadius+logoRadius));
                break;
            case "cat" :
                logo.setCenterX(9*(dLogoRadius+logoRadius));
                break;
        }
        logo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(main.money>=Logo.this.price){
                    main.money -= Logo.this.price ;
                    DomesticAnimal domesticAnimal = new DomesticAnimal(Logo.this.name) ;
                }
            }
        });
        logo.setCursor(Cursor.HAND);
        return logo ;
    }

    private Circle setCircle(int num){
        Circle circle = new Circle() ;
        circle.setCenterX(this.picture.getCenterX());
        circle.setCenterY(this.picture.getCenterY());
        if(num==1){
            circle.setRadius(this.picture.getRadius()+2);
            circle.setFill(Color.CYAN);
        } else if (num == 2 ){
            circle.setRadius(this.picture.getRadius()+4);
            circle.setFill(Color.YELLOW);
        }
        return circle ;
    }

    private Button setButton(){
        Button button = new Button();
        button.setLayoutX(this.picture.getCenterX()-this.picture.getRadius());
        button.setLayoutY(this.picture.getCenterY()+this.picture.getRadius()-3);
        button.setPrefWidth(2*(this.picture.getRadius()));
        button.setPrefHeight(20);
        button.setText(price+"");
        return button ;
    }

    public void add(Pane pane){
        pane.getChildren().add(circle2);
        pane.getChildren().add(circle1);
        pane.getChildren().add(picture);
        pane.getChildren().add(button);
    }

}
