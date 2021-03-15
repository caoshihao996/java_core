package DoublePtr;


/*
    牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
    有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的
    顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class JZ44 {

    public String ReverseSentence(String str) {

        int len = str.length();
        char[] chars = str.toCharArray();
        int i=0, j=0;
        while(j<=len){
            if(j==len || chars[j]==' '){
                reverse(chars, i, j-1);
                i = j+1;
            }
            j++;
        }
        reverse(chars, 0, len-1);
        return new String(chars);
    }

    public void reverse(char[] c, int i, int j){
        while(i<j){
            swap(c,i++,j--);
        }
    }

    public void swap(char[] chars, int i, int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
