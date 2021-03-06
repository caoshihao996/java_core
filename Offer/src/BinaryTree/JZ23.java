package BinaryTree;


/*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
    假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
 */
public class JZ23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        return verify(sequence, 0, sequence.length-1);
    }

    private boolean verify(int[] sequence, int first, int last){
        if(last-first<=1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        while(cutIndex<last && sequence[cutIndex]<=rootVal)
            cutIndex++;
        for(int i=cutIndex;i<last;i++){
            if(sequence[i]<rootVal)
                return false;
        }

        return verify(sequence, first, cutIndex-1) && verify(sequence, cutIndex, last-1);
    }
}
