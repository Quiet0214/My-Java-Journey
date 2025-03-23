package ClassLoader.StrategiesJar;

public class DiscountStrategy implements IPromotionStrategy{

    public double calculateDiscount(double price) {
        return price *0.9;
    }
}
