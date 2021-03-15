package ArrayAndMatrix;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
    在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class JZ34 {

    public int FirstNotRepeatingChar(String str){
        if(str==null || str.length()==0){
            return -1;
        }
        if(str.length()==1){
            return 0;
        }
        int[] arr = new int[58];
        for (char c : str.toCharArray()){
            arr[c-'A']++;
        }
        for(int i = 0; i<str.length();i++){
            if(arr[str.charAt(i)-'A']==1){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
