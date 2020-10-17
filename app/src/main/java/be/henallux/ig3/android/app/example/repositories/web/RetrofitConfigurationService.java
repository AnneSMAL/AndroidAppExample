package be.henallux.ig3.android.app.example.repositories.web;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitConfigurationService {
    private static final String BASE_URL = "https://henallux.free.beeceptor.com/";

    // Service Singleton instance
    private static RetrofitConfigurationService instance = null;

    // Moshi JSON Converter creation
    private static final Moshi MOSHI_CONVERTER = new Moshi.Builder()
            .add(new KotlinJsonAdapterFactory())
            .build();

    // Retrofit client creation
    private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(MOSHI_CONVERTER))
            .baseUrl(BASE_URL)
            .build();

    private static PizzaWebService pizzaWebService = null;


    public static RetrofitConfigurationService getInstance() {
        if (instance == null) {
            instance = new RetrofitConfigurationService();
        }
        return instance;
    }

    public PizzaWebService pizzaService() {
        if (pizzaWebService == null) {
            pizzaWebService = RETROFIT_CLIENT.create(PizzaWebService.class);
        }
        return pizzaWebService;
    }
}
