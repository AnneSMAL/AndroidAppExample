package be.henallux.ig3.android.app.example.repositories.web.dto;

import com.squareup.moshi.Json;

/**
 * Data Transfer Object. This kind of object is used to represent data transferred by a web service.
 * In an application, it is recommended to distinct your DTO from your Model objects, so that you
 * don't expose your database model to the outside
 */
public class PizzaDto {

    @Json(name = "id") // Corresponds to JSON key
    private Integer pizzaId;

    private String name; // If JSON key is same as variable name, no need of @Json annotation
    private Double price;
    private Boolean vegetarian;

    // Getters and setters are needed in your DTO, so that the converter object can map JSON keys to
    // the right variable (and use its getters/setters to update their content)

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
