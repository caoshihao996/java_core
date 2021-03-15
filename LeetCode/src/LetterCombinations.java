import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0){
            return res;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        char[] arr = digits.toCharArray();
        track(arr, 0, phoneMap, res, new StringBuffer());
        return res;
    }

    public void track(char[] str, int index, Map<Character, String> phoneMap, List<String> res, StringBuffer s){

        if(index==str.length){
            res.add(s.toString());
        }else{
            char digit = str[index];
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for(int i=0; i<letterCount; i++){
                s.append(letters.charAt(i));
                track(str, index+1, phoneMap, res, s);
                s.deleteCharAt(index);
            }
        }

    }

    @Test
    public void test(){
        System.out.println(letterCombinations("232"));
    }
}
