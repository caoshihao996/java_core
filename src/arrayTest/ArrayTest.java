package arrayTest;

public class ArrayTest {
    public static void main(String[] args){
        //1、一维数组的声明和初始化
        int[] ids;//声明
        ids = new int[]{1001,1002,1003,1004};//静态初始化：数组的初始化和赋值操作同时进行
        String[] names = new String[5];//动态初始化：数组的初始化和数组的元素赋值分开进行

        //数组一旦初始化完成，其长度就确定了

        names[0] = "阿里";
        names[1] = "小乔";
        names[2] = "大桥";
        //names[3] = "大桥";
        names[4] = "大桥";
        //names[5] = "大桥";
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }
        float[] zhengshu = new float[5];
        for(int i=0;i<zhengshu.length;i++){
            System.out.println(zhengshu[i]);
        }

        int array[][] = new int[][]{{1,2,3},{3,4},{5,6,7}};
        System.out.println(array[1].length);
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]);
            }
        }
        System.out.println();
        System.out.println(array[0]);

        int[][] array1 = new int[4][];
        System.out.println(array1[0]);//null指向引用对象
    }
}
