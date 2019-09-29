package generic;

public class GenericMethods {
    public <T,A> void f(T x, A a){
        System.out.println(x.toString()+" "+a.toString());
    }

    public static void main(String[] args){
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("hell0","world");

    }
}
