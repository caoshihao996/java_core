package ClassicProblem;

//最长公共子串（连续的是子串）
public class LCSubstring {

    public String lcs(String s1, String s2){
        if(s1 == null || s2 == null || s1.equals("") || s2.equals("")){
            return "";
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int row = 0;
        int col = str2.length - 1;
        int max = 0;
        int end = 0;
        while(row < str1.length){
            int i = row;
            int j = col;
            int len = 0;
            //向右下方移动这一轮
            while(i < str1.length && j<str2.length){
                if(str1[i]!=str2[j]){
                    len=0;
                }else{
                    len++;
                }
                if(len>max){
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if(col>0){
                col--;
            }else{
                row++;
            }
        }
        return s1.substring(end-max+1, end+1);
    }
}