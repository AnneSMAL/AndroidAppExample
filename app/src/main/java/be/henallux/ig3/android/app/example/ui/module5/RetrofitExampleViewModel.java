package be.henallux.ig3.android.app.example.ui.module5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.model.Pizza;
import be.henallux.ig3.android.app.example.repositories.web.PizzaWebService;
import be.henallux.ig3.android.app.example.repositories.web.RetrofitConfigurationService;
import be.henallux.ig3.android.app.example.repositories.web.dto.PizzaDto;
import be.henallux.ig3.android.app.example.services.mappers.PizzaMapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitExampleViewModel extends ViewModel {

    private static final PizzaWebService pizzaWebService = RetrofitConfigurationService
            .getInstance().pizzaService();
    private static final PizzaMapper pizzaMapper = PizzaMapper.getInstance();

    private MutableLiveData<Pizza> _pizza = new MutableLiveData<>();
    private LiveData<Pizza> pizza = _pizza;

    private MutableLiveData<NetworkError> _error = new MutableLiveData<>();
    private LiveData<NetworkError> error = _error;

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
                _error.setValue(NetworkError.TECHNICAL_ERROR);
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
        REQUEST_ERROR(R.string.request_error),
        TECHNICAL_ERROR(R.string.technical_error);

        private int errorMessage;

        NetworkError(int errorMessage) {
            this.errorMessage = errorMessage;
        }

        public int getErrorMessage() {
            return errorMessage;
        }
    }
}
