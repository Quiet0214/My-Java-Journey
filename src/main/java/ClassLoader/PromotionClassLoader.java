package ClassLoader;

import java.io.*;

public class PromotionClassLoader extends ClassLoader{
    private final String classPath;

    public PromotionClassLoader(String classPath) {
        this.classPath = classPath;
    }
    /*
    * 如果添加了这段代码，那么就是相当于重写了ClassLoader的loadClass方法，那么当程序执行会报以下的错误：
    * Exception in thread "main" java.lang.ClassCastException: ClassLoader.StrategiesJar.DiscountStrategy cannot be cast to ClassLoader.StrategiesJar.IPromotionStrategy
    * 产生原因就是因为IPromotionStrategy是由应用程序加载器加载的，而DiscountStrategy是由自定义的类加载器加载的，同一个类的全限定名被不同的类加载器加载会导致jvm认为他们是不同的类。
    *
    * */
//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        synchronized (getClassLoadingLock(name)) {
//            // 1. 先检查是否已加载
//            Class<?> c = findLoadedClass(name);
//            if (c != null) return c;
//
//            // 2. 如果是目标包下的类，优先自己加载
//            if (name.startsWith("ClassLoader.StrategiesJar")) {
//                return findClass(name);
//            }
//
//            // 3. 其他类仍委托父加载器
//            return super.loadClass(name);
//        }
//    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 1. 从指定目录读取.class文件字节码
            byte[] data = loadClassData(name);
            // 2. 调用defineClass将字节码转为Class对象
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("类未找到: " + name, e);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        String path = classPath + File.separator + className.replace('.', File.separatorChar) + ".class";
        System.out.println("[DEBUG] 加载路径: " + path); // 调试输出
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path + " 不存在");
        }
        try (FileInputStream fis = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
}
