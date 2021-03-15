import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {

    public static List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int end = 1;
        char[] arr = s.toCharArray();
        while (end < s.length()) {
            if(arr[start]==arr[end]){
                if(end+1==s.length() || arr[start]!=arr[end+1]){
                    if(end-start>=2){
                        List<Integer> l = new ArrayList<>();
                        l.add(start);
                        l.add(end);
                        list.add(l);
                    }
                    start = end;
                    end = end +1;
                }else{
                    end++;
                }
            }else{
                start = end;
                end = end +1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aba"));
    }
}
