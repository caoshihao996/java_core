package ArrayAndMatrix;

import org.junit.Test;

public class JZ2 {

    /*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
    则经过替换之后的字符串为We%20Are%20Happy
     */

    public String replaceSpace(String s){
        StringBuffer stringBuffer = new StringBuffer(s);
        int P1 = stringBuffer.length()-1;
        for(int i=0;i<=P1;i++){
            if(stringBuffer.charAt(i)==' '){
                stringBuffer.append("  ");
            }
        }

        int P2 = stringBuffer.length()-1;
        while(P1>=0 && P2>P1){
            char c = stringBuffer.charAt(P1--);
            if(c==' '){
                stringBuffer.setCharAt(P2--,'0');
                stringBuffer.setCharAt(P2--,'2');
                stringBuffer.setCharAt(P2--,'%');
            }else {
                stringBuffer.setCharAt(P2--,c);
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test(){
        String s = "we are happy";
        System.out.println(replaceSpace(s));
    }
}
