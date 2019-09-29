package abstractexample;

public class Tank extends Container {

    private double radius;
    private double length;

    public Tank(double initialRadius, double initialLength){
        radius = initialRadius;
        length = initialLength;
    }

    public double computeVolume(){
        return Math.PI*radius*radius*length;
    }

    public String toString(){
        return "Tank.computeVolume()";
    }
}
