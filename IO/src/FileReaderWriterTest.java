import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

    @Test
    public void test() {
        FileReader fr = null;
        try {
            //1.实例化file
            File file = new File("hello.txt");
            System.out.println(file.getAbsolutePath());

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据流读入
            //read():返回读入的字符，如果达到文件结尾返回-1
//        int data = fr.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data = fr.read();
//        }
            int data;
            while((data = fr.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4。流的关闭
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void test1()  {
        FileReader fr = null;

        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入操作
            char[] cbuf = new char[5];
            int len;
            while((len=fr.read(cbuf))!=-1){
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                    /*
                    String str = new String(cbuf, 0, len);
                     */
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr!=null)
                //4.资源的关闭
            {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFIleWriter() throws IOException {
        //1.提供File类的对象，指明写出到的文件。
        File file = new File("hello1.txt");
        //2.提供FileWriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file,true);

        //3.写出的操作
        fw.write("I have a dream!\n");
        fw.write("You have a dream");
        //4.流的关闭
        fw.close();
    }
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建file对象，指明读入和写出的文件
            File scrFile = new File("hello.txt");
            File desFile = new File("hello2.txt");

            //2.创建输入流和输出流对象
            fr = new FileReader(scrFile);
            fw = new FileWriter(desFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
