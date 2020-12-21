package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class NextHappy_01 {

    public static class Employee{
        public int happy;
        public List<Employee> nexts;

        public Employee(int h){
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static class Info{
        public int yes;//x节点来的情况下最大happy
        public int no;//x节点不来的情况下最大happy

        public Info(int y, int n){
            yes = y;
            no = n;
        }
    }

    public static Info process2(Employee x){
        if(x.nexts.isEmpty()){
            return new Info(x.happy, 0);
        }
        int yes = x.happy;
        int no = 0;
        for (Employee next : x.nexts){
            Info nextInfo = process2(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes, nextInfo.no);
        }
        return new Info(yes, no);
    }
}
