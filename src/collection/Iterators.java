package collection;


import java.util.*;

class PrintData{
    static void print(Iterator<String> e){
        while (e.hasNext()){
            System.out.println(e.next());
        }
    }
}
public class Iterators {
    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i=0;i<5;i++){
            arrayList.add(new String(String.valueOf(i)));
        }

        Vector<String> vector = new Vector<String>();
        for(int i=0;i<5;i++){
            vector.add(new String(String.valueOf(i)));
        }

        HashSet<String> hashSet =new HashSet<String>();
        for(int i=0; i<5; i++){
            hashSet.add(new String(String.valueOf(i)));
        }

        LinkedList<String> linkedList =new LinkedList<String>();
        for(int i = 0; i<5;i++){
            linkedList.add(new String(String.valueOf(i)));
        }

        for(String str:arrayList){
            System.out.println(str);
        }

        System.out.println("-------------");
        PrintData.print(arrayList.iterator());
        System.out.println("-------------");
        PrintData.print(vector.iterator());
        System.out.println("-------------");
        PrintData.print(hashSet.iterator());
        System.out.println("-------------");
        PrintData.print(linkedList.iterator());
    }
}
