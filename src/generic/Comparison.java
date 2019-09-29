package generic;

public class Comparison {

    public static <K extends Comparable>K min(K k1,K k2){
        if(k1.compareTo(k2)>0){
            return k2;
        }else{
            return k1;
        }
    }

    public static void main(String[] args){
        int m=0,n=100;
        int i = min(m,n);
        float j=12.6f,k=21.9f;
        float f = min(j,k);
        System.out.println("the min value of m and n is "+i+"\n the min value of j and k is "+f);
    }
}
