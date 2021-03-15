package BinaryTree;

import sun.reflect.generics.tree.Tree;

public class JZ61 {
    int index=-1;

    String Serialize(TreeNode root){
        if(root==null)
            return "#";
        else
            return root.val+","+Serialize(root.left)+","+Serialize(root.right);
    }

    TreeNode Deserialize(String str){
        String[] s = str.split(",");
        index++;
        int len = s.length;
        if(index>len)
            return null;
        TreeNode node = null;
        if(!s[index].equals("#")){
            node = new TreeNode(Integer.parseInt(s[index]));
            node.left = Deserialize(str);
            node.left = Deserialize(str);
        }
        return node;
    }
}
