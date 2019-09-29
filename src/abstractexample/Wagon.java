package abstractexample;

public class Wagon extends Container {

    private double width;
    private double height;
    private double length;

    public Wagon(double initWidth, double initHeight, double initLength){
        width = initWidth;
        height = initHeight;
        length = initLength;
    }

    @Override
    public double computeVolume() {
        return width*height*length;
    }

    public String toString(){
        return "Wagon.computeVolume()";
    }
}
