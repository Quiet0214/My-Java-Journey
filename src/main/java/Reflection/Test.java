package Reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;


/*
* 使用反射实现了一个日志记录的框架。
* 1.可以从配置文件中读取将怎样记录日志。
* 2.从配置文件中读取到类名，使用反射来进行日志记录
* 3.可以在不改动程序代码的，只改动配置文件的情况下，以不同形式来记录日志。
* */

public class Test {
    static Logger logger;
    public static void main(String[] args) {
        Properties properties = new Properties();

        try(InputStream is = Test.class.getClassLoader().getResourceAsStream("reflection.properties")){
            if(is!=null){
                properties.load(is);
            }

            String className = properties.getProperty("log.class");
            if (className == null || className.isEmpty()) {
                throw new IllegalArgumentException("配置项 logger.class 缺失");
            }
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("log",String.class);
            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            method.invoke(object,"你好！！！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
