import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {

    @Test
    public void test(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    @Test
    public void test2() throws Exception {

        Properties properties = new Properties();
        //方式1
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);

        //方式2
        //配置文件默认识别为当前Module下的src
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(is);


        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = "+user+" password = "+password);
    }
}
