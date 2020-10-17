package be.henallux.ig3.android.app.example.repositories.web;

import be.henallux.ig3.android.app.example.repositories.web.dto.PizzaDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Java Interface, exposing your different endpoints
 */
public interface PizzaWebService {

    @GET("pizza/{pizzaId}")
    Call<PizzaDto> getPizza(@Path("pizzaId") Integer pizzaId);
}
