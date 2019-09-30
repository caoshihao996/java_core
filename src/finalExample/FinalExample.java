package finalExample;


class Channel{
    private final int ON = 1;
    private final int OFF = 0;

    public final void connect(){
        //ON = 2;//无法为常量ON分配值
    }
}

class DataBaseChannel extends Channel{
    //public void connect(){ }connect在父类中为常量函数不能被覆写
}

public class FinalExample {
    public static void main(String[] args){

    }
}
