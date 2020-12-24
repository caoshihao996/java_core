package RecursiveToDP;

import java.util.ArrayList;

public class PrintAllPermutations {


    //str[0...i-1]都已经做好决定
    //str[i...]都有机会来到i位置
    //i终止位置，str当前的位置就是一种结果->ans
    public static void process(char[] str, int i, ArrayList<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
        }
        //如果i没有终止，i...都可以来到i位置
        for(int j=i;j<str.length;j++){
            swap(str,i,j);
            process(str, i+1, res);
            swap(str,i,j);//恢复，往上退
        }
    }

    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    //打印字符串所有的排列方式，没有重复
    public static void process2(char[] str, int i, ArrayList<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];//26个字母，当前位置的选择，不与其他位置共享
        for(int j = i; j<str.length;j++){
            if(visit[str[j] - 'a'] == false){
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process2(str, i+1,res);
                swap(str, i, j);
            }
        }
    }
}
