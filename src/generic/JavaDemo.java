package generic;
//class Point{
//    private Object x;
//    private Object y;
//    public void setX(Object x){
//        this.x = x ;
//    }
//    public void setY(Object y){
//        this.y = y;
//    }
//    public Object getX(){
//        return this.x;
//    }
//    public Object getY(){
//        return this.y;
//    }
//}
//class Point<T>{
//    private T x;
//    private T y;
//    public void setX(T x){
//        this.x = x ;
//    }
//    public void setY(T y){
//        this.y = y;
//    }
//    public T getX(){
//        return this.x;
//    }
//    public T getY(){
//        return this.y;
//    }
//}
class Message<T>{//泛型的上限用extends Number，Number子类,下线用super String,String及其父类
    private T content;
    public void setContent(T content){
        this.content = content;
    }
    public T getContent(){
        return this.content;
    }
}
public class JavaDemo {
    public static void main(String[] args){
//        Point<Integer> point = new Point<>();//不设置，则默认用object接受
//        point.setX(10);
//        point.setY(20);
//
//        int x = (Integer)point.getX();
//        int y = (Integer)point.getY();
//        System.out.println(x);
//        System.out.println(y);
        Message<String> message = new Message<>();
        message.setContent("nihao");
        fun(message);
        Message<Integer> msg = new Message<>();
        msg.setContent(1);
        fun(msg);
    }
//    public static void fun(Message<String> temp){//值传递如何使用泛型
//        System.out.println(temp.getContent());
//    }
//    public static void fun(Message temp){//不设置泛型，但此情况允许修改值
//        temp.setContent(1.1);
//        System.out.println(temp.getContent());
//    }
public static void fun(Message<?> temp){//通配符？ ，不允许修改数值，但可以访问
    //temp.setContent(1.1);eror
    System.out.println(temp.getContent());
}
}
