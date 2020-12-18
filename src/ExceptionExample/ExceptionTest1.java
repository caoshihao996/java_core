package ExceptionExample;


/*一、
   过程一：“抛”：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象
                并将此对象抛出。
                一旦抛出对象以后，其后的代码就不再执行。

   过程而：“抓”：可以理解为异常的处理方式1try-catch-finally 2throws


   二、try-catch-finally的使用
   try{
        //可能出现的异常的代码
       }catch(异常类型1 变量名1){
            //处理方式1
       }catch(异常类型2 变量名2){
            //处理方式2
       }

       finally{
             //一定会执行的代码

       }


       说明：
       1.finally是可选的
       2.使用try将可能的异常爆装起来，在执行过程中，一旦出现异常就会生成一个对应异常类的对象，根据此对象的类型，区catch中进行匹配
       3.一旦try中的异常对象匹配到某一个catch是，就进入catch中进行异常处理，一旦处理完成就跳出当前的try-catch机构（没有写finally情况下）继续执行其后的代码
 */
public class ExceptionTest1 {

    public static void main(String[] args) {
        String str = "123";
        str = "abc";
        try{
            int num = Integer.parseInt(str);
            System.out.println("hello-1");
        }catch (NumberFormatException e){
            System.out.println("出现了数值转换异常");
        }
        System.out.println("hello-2");
    }
}
