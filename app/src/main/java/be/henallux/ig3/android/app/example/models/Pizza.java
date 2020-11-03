package be.henallux.ig3.android.app.example.models;

public class Pizza {
    private String name;
    private Double price;
    private Boolean vegetarian;

    public Pizza(String name, Double price, Boolean vegetarian) {
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean forVegetarian() {
        return vegetarian;
    }
}
