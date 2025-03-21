import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
* 电商商品排序系统，用于熟悉Comparable接口和Comparator接口。
* */
public class ECommerceProductSorting {
    public static void main(String[] args) {
        Product phone = new Product("手机",1000,100);
        Product computer = new Product("电脑",5000,20);
        Product airpods = new Product("耳机",500,500);
        List<Product> products = new ArrayList<>();
        products.add(phone);
        products.add(computer);
        products.add(airpods);

        /*
        * Product自身实现了Comparable接口，按照价格升序。
        * */
        Collections.sort(products);
        for(Product product:products){
            System.out.print(product+" ");
        }
        System.out.println();


        /*
        * 按照名称升序
        * */
        Collections.sort(products,new ProductNameComparator());
        for(Product product:products){
            System.out.print(product+" ");
        }
        System.out.println();

        /*
        * 按照销量升序
        * */
        Collections.sort(products,new ProductSalesComparator());
        for(Product product:products){
            System.out.print(product+" ");
        }
        System.out.println();
    }
}

class Product implements Comparable<Product>{
    private String name;
    private int price;
    private int sales;

    public Product() {
    }

    public Product(String name, int price, int sales) {
        this.name = name;
        this.price = price;
        this.sales = sales;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取
     * @return sales
     */
    public int getSales() {
        return sales;
    }

    /**
     * 设置
     * @param sales
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    public String toString() {
        return "Product{name = " + name + ", price = " + price + ", sales = " + sales + "}";
    }

    @Override
    public int compareTo(Product o) {
        return this.price-o.price;
    }
}

class ProductSalesComparator implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getSales()-o2.getSales();
    }
}

class ProductNameComparator implements  Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }
}
