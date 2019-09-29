package abstractexample;

public class ContainerDemo {
    private static final String NEW_LINE = System.getProperty("line.separator");

    public static Container randContainer(){
        double width = Math.random()*100;
        double height = Math.random()*200;
        double length = Math.random()*300;
        double radius = Math.random()*400;
        switch ((int)(Math.random()*3)){
            default:
            case 0:return new Wagon(width, height, length);
            case 1:return new Tank(radius, length);
        }
    }

    public static void main(String[] args){
        String out = "";
        Container[] containers = new Container[10];
        for(int i=0;i<containers.length;i++){
            containers[i] = ContainerDemo.randContainer();
        }
        for(int i=0;i<containers.length;i++){
            double volume = containers[i].computeVolume();
            out = out+containers[i]+volume+NEW_LINE;
        }
        System.out.println(out);
    }
}
