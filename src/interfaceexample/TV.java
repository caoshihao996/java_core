package interfaceexample;

import java.io.PrintWriter;

public class TV implements Device{
    PrintWriter stdOut = new PrintWriter(System.out, true);

    private String name;

    public TV(String initialName){
        name = initialName;
    }

    public void turnOn(){
        stdOut.println("Turn on the device"+ name);
    }

    public void turnOff(){
        stdOut.println("Turn off the device"+name);
    }

    public static void main(String[] args){
        Device device = new TV("TV");
        device.turnOn();
        device.turnOff();
        System.out.println(device);
    }

    @Override
    public String toString() {
        return "TV";
    }
}
