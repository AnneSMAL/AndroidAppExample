package be.henallux.ig3.android.app.example.ui.module5;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.model.Pizza;
import be.henallux.ig3.android.app.example.repositories.web.PizzaWebService;
import be.henallux.ig3.android.app.example.repositories.web.RetrofitConfigurationService;
import be.henallux.ig3.android.app.example.repositories.web.dto.PizzaDto;
import be.henallux.ig3.android.app.example.services.mappers.PizzaMapper;
import be.henallux.ig3.android.app.example.utils.errors.NoConnectivityException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitExampleViewModel extends AndroidViewModel {

    private MutableLiveData<Pizza> _pizza = new MutableLiveData<>();
    private LiveData<Pizza> pizza = _pizza;

    private MutableLiveData<NetworkError> _error = new MutableLiveData<>();
    private LiveData<NetworkError> error = _error;

    private PizzaWebService pizzaWebService;
    private PizzaMapper pizzaMapper;

    public RetrofitExampleViewModel(@NonNull Application application) {
        super(application);
        this.pizzaWebService = RetrofitConfigurationService.getInstance(application).pizzaService();
        this.pizzaMapper = PizzaMapper.getInstance();
    }

    public void getPizzaFromWeb() {
        // Enqueue method is starting a new background thread and executing the corresponding
        // HTTP request inside. The Callback object permits to define the behaviour to adopt
        // after the request is performed.
        pizzaWebService.getPizza(1).enqueue(new Callback<PizzaDto>() {
            @Override
            public void onResponse(@NotNull Call<PizzaDto> call, @NotNull Response<PizzaDto> response) {
                // Garnish your LiveData, so that View will be notified we receive information
                // from web service
                if (response.isSuccessful()) {
                    _pizza.setValue(pizzaMapper.mapToPizza(response.body()));
                    _error.setValue(null);
                } else {
                    _error.setValue(NetworkError.REQUEST_ERROR);
                }
            }

            @Override
            public void onFailure(@NotNull Call<PizzaDto> call, @NotNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    _error.setValue(NetworkError.NO_CONNECTION);
                } else {
                    _error.setValue(NetworkError.TECHNICAL_ERROR);
                }
            }
        });
    }

    public LiveData<Pizza> getPizza() {
        return pizza;
    }

    public LiveData<NetworkError> getError() {
        return error;
    }

    public enum NetworkError {
        NO_CONNECTION(R.drawable.ic_no_connectivity, R.string.http_no_connection),
        REQUEST_ERROR(R.drawable.ic_error, R.string.request_error),
        TECHNICAL_ERROR(R.drawable.ic_error, R.string.technical_error);

        private int errorDrawable;
        private int errorMessage;

        NetworkError(int errorDrawable, int errorMessage) {
            this.errorDrawable = errorDrawable;
            this.errorMessage = errorMessage;
        }

        public int getErrorDrawable() {
            return errorDrawable;
        }

        public int getErrorMessage() {
            return errorMessage;
        }
    }
}
