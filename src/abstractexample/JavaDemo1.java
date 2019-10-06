package abstractexample;
abstract class AbstractShape{
    public abstract double area();
    public abstract double perimeter();
}
class Circular1 extends AbstractShape{
    private double r;


    public Circular1(double r){
        this.r = r;
    }
    @Override
    public double area(){
        return r*r*Math.PI;
    }

    @Override
    public double perimeter() {
        return r*2*Math.PI;
    }
}
class Rectangle extends AbstractShape{
    private double h;
    private double w;
    public Rectangle(double h, double w){
        this.h = h;
        this.w = w;
    }

    @Override
    public double area() {
        return this.w*this.h;
    }

    @Override
    public double perimeter() {
        return 2*(w+h);
    }
}
class Factory1{
    public static AbstractShape getInstance(String className, double ...args){
        if("circular".equalsIgnoreCase(className)){
            return new Circular1(args[0]);
        }else if("rectangle".equalsIgnoreCase(className)){
            return new Rectangle(args[0], args[1]);
        }else{
            return null;
        }
    }
}
public class JavaDemo1 {
    public static void main(String[] args){
        AbstractShape asa = Factory1.getInstance("circular",4.0);
        System.out.println("面积："+asa.area()+"周长："+asa.perimeter());
        AbstractShape asb = Factory1.getInstance("rectangle",4,5);
        System.out.println("面积："+asb.area()+"周长："+asb.perimeter());
    }
}
