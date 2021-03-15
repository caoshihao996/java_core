import java.util.ArrayList;
import java.util.List;

public class Z_Convert {

    public static String convert(String s, int numRows) {

        if(numRows==1 || s.length()==1){
            return s;
        }
        int n = Math.min(numRows, s.length());
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;

        for(char c : s.toCharArray()){
            list.get(curRow).append(c);
            if(curRow==0 || curRow==numRows-1){
                goDown= !goDown;
            }
            curRow += goDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder str : list){
            res.append(str);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
