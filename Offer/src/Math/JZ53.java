package Math;

/*
    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
    但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class JZ53 {

    public boolean isNumeric (String str) {
        // write code here
        char[] array = str.toCharArray();
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i]=='e' || array[i]=='E'){
                if(i==array.length-1)return false;
                if(hasE)return false;
                hasE=true;
            }else if(array[i]=='+' || array[i]=='-'){
                if(sign&&array[i-1]!='e'&&array[i-1]!='E')return false;
                if(!sign && i>0 && array[i-1]!='e' && array[i-1]!='E')return false;
                sign = true;
            }else if(array[i]=='.'){
                if(hasE || decimal)return false;
                decimal = true;
            }else if(array[i]<'0' || array[i]>'9')return false;
        }
        return true;
    }
}
