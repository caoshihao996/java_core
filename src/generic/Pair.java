package generic;

public class Pair<A,B> {
    /*private String element1;
    private String element2;
    public Pair(String element1,String element2){
        this.element1 =element1;
        this.element2 =element2;
    }

    public String getElement1(){
        return element1;
    }

    public String getElement2() {
        return element2;
    }*/

    private A element1;
    private B element2;

    public Pair(A element1,B element2){
        this.element1 = element1;
        this.element2 = element2;
    }
    public A getElement1(){
        return element1;
    }

    public B getElement2() {
        return element2;
    }

    public static void main(String[] args){
        Pair<String,String> pairOne = new Pair<String,String>("a","b");
        System.out.println(pairOne.getElement1()+" "+pairOne.getElement2());

        Pair<Integer,Integer> pairTwo = new Pair<Integer,Integer>(1,1);
        System.out.println(pairTwo.getElement1()+" "+pairTwo.getElement2());

        Pair<Double,Double> pairthree = new Pair<Double,Double>(1.0,1.0);
        System.out.println(pairthree.getElement1()+" "+pairthree.getElement2());
    }
}
