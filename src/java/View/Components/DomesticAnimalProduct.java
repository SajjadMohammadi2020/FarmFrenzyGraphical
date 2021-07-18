package View.Components;

import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Locale;

public class DomesticAnimalProduct extends Rectangle {

    public static ArrayList<DomesticAnimalProduct> allDomesticAnimalProducts = new ArrayList<>();

    public static int productWidth = 40 ;
    public static int productHeight = 40 ;

    public String name ;
    public Pane pane ;
    public double life = 8 ;
    private boolean deleted = false ;

    DomesticAnimalProduct(double x , double y , String name , Pane pane){
        super(x,y,productWidth,productHeight);
        name = name.toLowerCase(Locale.ROOT);
        this.pane = pane ;
        this.name = name ;
        this.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/pictures/product/"+this.name+".png").toExternalForm())));
        this.pane.getChildren().add(1,this);
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DomesticAnimalProduct.this.setEffect(new Glow());
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DomesticAnimalProduct.this.setEffect(null);
            }
        });
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //////////transfer to warehouse
                System.out.println("warehouse");
                remove();
            }
        });
        allDomesticAnimalProducts.add(this);
    }

    public void remove(){
        if(!deleted) {
            pane.getChildren().remove(this);
            deleted = true ;
        }
    }

}
