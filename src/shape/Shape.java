package shape;

class Shapes {

    void draw(){}
    void erase(){}
}

class Circle extends Shapes{
    @Override
    void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Circle.erase()");
    }
}

class Square extends Shapes{
    @Override
    void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    void erase() {
        System.out.println("Square.erase()");
    }
}

class Triangle extends Shapes{
    @Override
    void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Triangle.erase()");
    }
}

public class Shape{
    public static Shapes randShape(){
        switch ((int)(Math.random()*3)){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return new Triangle();
        }
    }

    public static void main(String[] args){
        Shapes[] s = new Shapes[9];
        for(int i=0;i<9;i++){
            s[i] = randShape();
            s[i].draw();
        }
    }
}


