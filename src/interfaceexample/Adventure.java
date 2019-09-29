package interfaceexample;

interface CanFight{
    void fight();
}

interface CanSwim{
    void swim();
}

interface CanFly{
    void fly();
}

interface Animal extends CanFly,CanSwim,CanFight{
    void run();
}

class ActionCharacter{
    public void fight(){
        System.out.println("ActionCharacter.fight()");
    }
}

class Hero extends ActionCharacter implements Animal{
    public void swim(){
        System.out.println("Hero.Swim()");
    }

    public void fly(){
        System.out.println("Hero.fly()");
    }

    @Override
    public void run() {
        System.out.println("Hero.run()");
    }

    /*@Override
    public void fight() {
        System.out.println("Hero.fight()");
    }*/
}

public class Adventure {

    static void t(CanFight x){
        x.fight();
    }
    static void u(CanSwim x){
        x.swim();
    }
    static void v(CanFly x){
        x.fly();
    }
    static void w(ActionCharacter x){
        x.fight();
    }
    public static void main(String[] args){
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
