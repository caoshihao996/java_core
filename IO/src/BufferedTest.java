import org.junit.Test;

import java.io.*;

public class BufferedTest {

    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File scrFile = new File("1.png");
            File desFile = new File("3.png");

            FileInputStream fis = new FileInputStream(scrFile);
            FileOutputStream fos = new FileOutputStream(desFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭外层的同时，内层流也会关闭
//        fos.close();
//        fis.close();
        }

    }

    public void copyFile(String srcPath, String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File scrFile = new File(srcPath);
            File desFile = new File(destPath);

            FileInputStream fis = new FileInputStream(scrFile);
            FileOutputStream fos = new FileOutputStream(desFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭外层的同时，内层流也会关闭
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();

        String srcPath = "1.png";
        String desPath = "3.png";

        copyFile(srcPath,desPath);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    @Test
    public void test2(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("hello.txt");
            File desFile = new File("hello2.txt");

            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(desFile));

//            char[] cbuf = new char[5];
//            int len;
//            while ((len=br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//            }
            String data;
            while ((data=br.readLine())!=null){
                bw.write(data+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
