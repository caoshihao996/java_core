package abstractexample;
interface IGraphical{
    public void paint();
}

class Point{
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
}

class Triangle implements IGraphical{
    private Point [] x;
    private Point [] y;
    private Point [] z;
    public Triangle(Point []x, Point []y, Point []z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void paint(){
        System.out.println("绘制第一条边，开始坐标：("+x[0].getX()+","+x[0].getY()+") 结束坐标：（"+x[1].getX()+","+x[1].getY()+")");
        System.out.println("绘制第二条边，开始坐标：("+y[0].getX()+","+y[0].getY()+") 结束坐标：（"+y[1].getX()+","+y[1].getY()+")");
        System.out.println("绘制第三条边，开始坐标：("+z[0].getX()+","+z[0].getY()+") 结束坐标：（"+z[1].getX()+","+z[1].getY()+")");
    }
}

class Circular implements IGraphical{
    private Point center;
    private double radius;
    public Circular(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }
    public void paint(){
        System.out.println("绘制圆，圆心：("+ center.getX()+","+center.getY()+")"+",半径："+this.radius);
    }
}

class Factory{
    public static IGraphical getInstance(String className, double ...args){
        if("triangle".equalsIgnoreCase(className)){
            return new Triangle(
                    new Point[]{
                        new Point(args[0],args[1]),new Point(args[2], args[3])},
                    new Point[]{
                            new Point(args[2], args[3]), new Point(args[4], args[5])
                    },
                    new Point[]{
                            new Point(args[4], args[5]),new Point(args[0], args[1])});
        }else if("circular".equalsIgnoreCase(className)){
            return new Circular(new Point(args[0],args[1]), args[2]);
        }else{
            return null;
        }
    }
}
public class JavaDemo {

    public static void main(String[] args){
        IGraphical igc = Factory.getInstance("triangle", 0,0,1,1,1,0);
        igc.paint();
        IGraphical igc1 = Factory.getInstance("circular",0,0,1);
        igc1.paint();
    }
}
