package DP;

public class DecodeWays {

    int cnt=0;
    public int numDecodings(String s) {

        if (s==null || s.length()==0)
            return 0;
        return process(s.toCharArray(), 0);
    }

    private int process(char[] str, int index){
        if(index==str.length)
            return 1;
        if(str[index]=='0')
            return 0;


        if(str[index]=='1'){
            int res = process(str, index+1);
            if(index+1<str.length){
                res += process(str, index+2);
            }
            return res;
        }

        if(str[index]=='2'){
            int res = process(str, index+1);
            if(index+1<str.length && str[index+1]<='6' && str[index]>='0'){
                res += process(str, index+2);
            }
            return res;
        }
        return process(str, index+1);
    }

}
