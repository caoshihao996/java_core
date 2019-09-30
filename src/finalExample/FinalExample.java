package finalExample;


class Channel{
    //private final int ON = 1;
    private final int OFF = 0;
    public static final int ON =1;//一般定义为全局常量，常量名字一般大写

    public final void connect(){
        //ON = 2;//无法为常量ON分配值
    }
}

class DataBaseChannel extends Channel{
    //public void connect(){ }connect在父类中为常量函数不能被覆写
}

public class FinalExample {
    public static void main(String[] args){
        final String info = "nwpu";
        String string1 = "www.nwpu.edu.cn";
        String string2 = "www."+info+".edu.cn";
        System.out.println((string1==string2));
    }
}
