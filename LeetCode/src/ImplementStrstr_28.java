import org.junit.Test;

public class ImplementStrstr_28 {

    public int strStr(String haystack, String needle) {

        if(needle==null || needle.length()==0){
            return 0;
        }
        if(haystack==null){
            return -1;
        }
        int n = haystack.length();
        int L = needle.length();
        int i=0;
        while(i<n-L+1){
            while(i<n-L+1 && haystack.charAt(i)!=needle.charAt(0))i++;

            int curLen = 0, j = 0;
            while(j<L && i<n && haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                curLen++;
            }

            if(curLen==L)return i-j;
            i = i - curLen +1;
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(strStr("mississippi", "issip"));
    }
}
