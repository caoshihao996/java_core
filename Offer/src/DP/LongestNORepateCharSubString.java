package DP;


import java.util.Arrays;

/*
    输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
    例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4
 */
public class LongestNORepateCharSubString {

    public int longestSubStringWithoutDuplication(String str){
        if (str==null || str.length()==0)
            return 0;
        int n = str.length();
        int curLen=0;
        int maxLen=0;
        int[] preIndexs = new int[26];
        char[] arr = str.toCharArray();
        Arrays.fill(preIndexs,-1);
        for (int i = 0; i < n; i++) {
            int c = arr[i] - 'a';
            int preI = preIndexs[c];
            if(preI==-1 || i - preI > curLen)
                curLen++;
            else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - preI;
            }
            preIndexs[c] = i;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
