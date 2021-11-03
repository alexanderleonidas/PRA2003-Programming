/**
 * PRA2003 2021 Week 2, Task 2
 * @author Alexander Leonidas
 */

interface Linear{
    ;
}

// Abstract class that maintains information about specific shapes
abstract class Shape{
    /** 
     * @return Number of sides. 
     **/

    public abstract int numSides();

    @Override
    public String toString(){
        String s = (this instanceof Linear) ? " linear sides.": " sides.";
        return "This " + this.getClass().getSimpleName() + " has " + numSides() + s;
    }
}

// Class that describes a Circle
class Circle extends Shape{
    @Override
    public int numSides(){
        return 1;
    }
} 

class Triangle extends Shape implements Linear{
    public int numSides(){
        return 3;
    }
}

class Rectangle extends Shape implements Linear{
    public int numSides(){
        return 4;
    }
}

class Square extends Rectangle{
;
}

class Polygon extends Shape implements Linear{
    int sides;

    public Polygon(final int n){
        this.sides = n;
    }

    public int numSides(){
        return sides;
    }
}

public class Shapes{
    public static void main(String[] args) {
        final Shape[] shapes = {
            new Circle(), 
            new Triangle(), 
            new Square(), 
            new Rectangle(), 
            new Polygon(3), 
            new Polygon(6)};

        for(Shape shape : shapes){
            System.out.println(shape);
        } 
    }
}