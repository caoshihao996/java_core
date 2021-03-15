package BackTracking;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/*
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
    则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class JZ27 {

    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()==0)
            return ret;
        char[] array = str.toCharArray();
        process(array, 0);
        Collections.sort(ret);
        return ret;
    }

    private void process(char[] array, int index){
        if (index==array.length)
            ret.add(String.valueOf(array));
        boolean[] visit = new boolean[58];
        for(int i=index;i<array.length;i++){
            if(visit[array[i]-'A']==false){
                visit[array[i]-'A']=true;
                swap(array,i,index);
                process(array,index+1);
                swap(array,i,index);
            }
        }
    }

    private void swap(char[] array, int i, int j){
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Test
    public void test(){
        String str= "abc";
        System.out.println(Permutation(str));
    }

}
