import java.util.Stack;

class Node1{
    int value;
    Node1 left;
    Node1 right;
    Node1(int v){
        value = v;
    }
}

public class BinTreeTest {
    public static void main(String[] args) {
        Node1 head = new Node1(1);
        head.left = new Node1(2);
        head.right = new Node1(3);
        in1(head);
    }

    //先序打印所有节点,递归方式
    public static void pre(Node1 head){
        if(head==null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    //中序遍历打印所有节点，递归方式
    public static void in(Node1 head){
        if(head==null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    //后序遍历打印所有节点，递归方式
    public static void pos(Node1 head){
        if(head==null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    //非递归方式实现二叉树的先序、中序、后序遍历
    //1）任何递归函数都可以改成非递归  2）自己设计压栈实现
    /**
     *  先序遍历的非递归方法
     *   1）弹打印
     *   2）如有右，压入右
     *   3）如有左，压入左
     */

    public static void pre1(Node1 head){
        if(head != null){
            Stack<Node1> stack = new Stack<Node1>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value+" ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //后序遍历的非递归方法
    public static void pos1(Node1 head){
        if(head != null){
            Stack<Node1> s1 = new Stack<Node1>();
            Stack<Node1> s2 = new Stack<Node1>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head.left);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while(!s2.empty()){
                System.out.print(s2.pop().value+" ");
            }
        }
        System.out.println();
    }

    //用一个栈实现非递归的后序遍历
    public static void pos2(Node1 h){
        if(h != null){
            Stack<Node1> stack = new Stack<Node1>();
            stack.push(h);
            Node1 c = null;
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && h!=c.left && h != c.right){
                    stack.push(c.left);
                }else if(c.right != null && h!=c.right){
                    stack.push(c.right);
                }else{
                    System.out.println(stack.pop()+" ");
                    h=c;
                }
            }
        }
        System.out.println();
    }

    ///中序遍历的非递归方法
    //1）整条左边界依次入栈  2）1）无法继续，弹出打印，右树进行1）
    public static void in1(Node1 head){
        if(head != null){
            Stack<Node1> stack = new Stack<Node1>();
            while(!stack.isEmpty() || head!=null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value+ " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
}


