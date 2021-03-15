import org.junit.Test;

public class LambdaTest {


    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();
        System.out.println("******************");

        Runnable r2 = ()-> System.out.println("我爱北京故宫");
        r2.run();
    }
}
