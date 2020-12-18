package finalExample;

public class FinalTest {

    final int WIDTH = 10;
//    final int width;
    final int LEFT;
    {
        LEFT = 1;
    }

    final int RIGHT;
    public FinalTest(){
        RIGHT = 2;
    }

}

//该类不能被继承，太监类
final class FinalA{

}
//修饰方法，该方法不能被重写
class A{
    public final void show(){

    }
}

class B extends A{
//    public void show(){
//
//    }
}

