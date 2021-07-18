package View;

import java.util.Random;

public class Animal {
    String name ;
    double life ;
    double x ;
    double y ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] newLoc(){
        double[] result = new double[2];
        Random random = new Random();
        int x = random.nextInt(4) ;
        switch (x){
            case 0 :
                result[0] = this.x - 1 ;  //left
                result[1] = this.y ;
                break;
            case 1:
                result[0] = this.x ;
                result[1] = this.y - 1 ;  //up
                break;
            case 2 :
                result[0] = this.x + 1 ;  //right
                result[1] = this.y ;
                break;
            case 3:
                result[0] = this.x ;
                result[1] = this.y + 1 ;  //bottom
                break;
        }
        return result ;
    }

}
