import org.junit.Test;

import java.io.*;

public class FileInputOutputStramTest {

    @Test
    public void testFileinputStram(){
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileCopy(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcImage = new File("1.png");
            File desImage = new File("2.png");

            fis = new FileInputStream(srcImage);
            fos = new FileOutputStream(desImage);

            byte[] buffer = new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
