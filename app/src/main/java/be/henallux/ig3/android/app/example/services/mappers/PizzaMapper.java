package be.henallux.ig3.android.app.example.services.mappers;

import be.henallux.ig3.android.app.example.model.Pizza;
import be.henallux.ig3.android.app.example.repositories.web.dto.PizzaDto;

public class PizzaMapper {
    private static PizzaMapper instance = null;

    public static PizzaMapper getInstance() {
        if (instance == null) {
            instance = new PizzaMapper();
        }
        return instance;
    }

    public Pizza mapToPizza(PizzaDto dto) {
        if (dto == null) {
            return null;
        }

        return new Pizza(dto.getName(), dto.getPrice(), dto.getVegetarian());
    }
}
