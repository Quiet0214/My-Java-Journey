package ClassLoader.StrategiesJar;

public class FullReductionStrategy implements IPromotionStrategy{

    public double calculateDiscount(double price) {
        return price >= 200 ? price - 50 : price;
    }
}
