import java.util.HashMap;

public class RomanToInt {

    public static int romanToInt(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int res = 0;
        char[] arr = s.toCharArray();
        int i = 0;
        while(i<s.length()) {
            if(arr[i]=='I'){
                if(i+1<s.length() && arr[i+1]=='V'){
                    res+=4;
                    i+=2;
                }else if(i+1<s.length() && arr[i+1]=='X'){
                    res+=9;
                    i+=2;
                }else{
                    res+=1;
                    i++;
                }
            }else if(arr[i]=='X'){
                if(i+1<s.length() && arr[i+1]=='L'){
                    res+=40;
                    i+=2;
                }else if(i+1<s.length() && arr[i+1]=='C'){
                    res+=90;
                    i+=2;
                }else{
                    res+=10;
                    i++;
                }
            }else if(arr[i]=='C'){
                if(i+1<s.length() && arr[i+1]=='D'){
                    res+=400;
                    i+=2;
                }else if(i+1<s.length() && arr[i+1]=='M'){
                    res+=900;
                    i+=2;
                }else{
                    res+=100;
                    i++;
                }
            }else if(arr[i]=='V'){
                res+=5;
                i++;
            }else if(arr[i]=='L'){
                res+=50;
                i++;
            }else if(arr[i]=='D'){
                res+=500;
                i++;
            }else if(arr[i]=='M'){
                res+=1000;
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
