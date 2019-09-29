package interfaceexample;

public class LightBulb implements Device{

    private String name;

    public LightBulb(String initialName){
        name = initialName;
    }

    public void turnOff(){
        System.out.println("Turn on the device "+name);
    }

    public void turnOn(){
        System.out.println("Turn on the device "+name);
    }

    public static void main(String[] args){
        Device device = new LightBulb("LightBulb");
        device.turnOn();
        device.turnOff();

        int sum =0;
        for(int x =0 ;x<10;x++){
            sum+=x;
            if(x%3==0){
                break;
            }
        }
        System.out.println(sum);
    }
}
