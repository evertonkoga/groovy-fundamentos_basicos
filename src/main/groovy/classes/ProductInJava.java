package classes;

public class ProductInJava {
    private String name;
    private double price;

    public ProductInJava(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public double getPrice() {
        System.out.println("getPrice");
        return price;
    }

    public void setPrice(double price) {
        System.out.println("setPrice");
        this.price = price;
    }
}
