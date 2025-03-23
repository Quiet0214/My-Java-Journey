package ClassLoader;

import ClassLoader.StrategiesJar.IPromotionStrategy;

/*
* 尝试使用自定义类加载器来加载不同的优惠策略来决定当前的优惠策略。
* 但是遇到了不同类加载器会导致加载出来的类是不同的类的问题
* TODO 将策略包中的所有类使用自定义加载器加载为.class文件，然后打包成jar包引入。main方法使用和加载策略类相同的自定义类加载器来加载。
* */


public class EShopMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String strategyName = "ClassLoader.StrategiesJar.DiscountStrategy";
        String classPath = "D:\\develop\\ideaProjects\\My-Java-Journey\\target\\classes";
        PromotionClassLoader loader = new PromotionClassLoader(classPath);
        System.out.println();
        Class<?> clazz = loader.loadClass(strategyName);
        IPromotionStrategy strategy = (IPromotionStrategy) clazz.newInstance();
        double price = 200;
        double finalPrice = strategy.calculateDiscount(200);

        System.out.println("=============类加载过程=============");
        System.out.println("创建自定义类加载器："+loader);
        System.out.println("从指定jar包中读取优惠策略："+classPath);
        System.out.println("策略为："+strategy);
        System.out.println("==================================");
        System.out.println("原价为："+price);
        System.out.println("现价为："+finalPrice);
    }
}
