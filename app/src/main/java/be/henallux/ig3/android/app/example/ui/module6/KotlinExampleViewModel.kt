package be.henallux.ig3.android.app.example.ui.module6

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import be.henallux.ig3.android.app.example.models.NetworkError
import be.henallux.ig3.android.app.example.models.Pizza
import be.henallux.ig3.android.app.example.repositories.web.RetrofitConfigurationService
import be.henallux.ig3.android.app.example.repositories.web.dto.PizzaDto
import be.henallux.ig3.android.app.example.services.mappers.PizzaMapper
import be.henallux.ig3.android.app.example.utils.errors.NoConnectivityException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KotlinExampleViewModel(application: Application) : AndroidViewModel(application) {
    private val _pizza = MutableLiveData<Pizza>()
    val pizza: LiveData<Pizza> = _pizza

    private val _error = MutableLiveData<NetworkError?>()
    val error: LiveData<NetworkError?> = _error

    private var pizzaWebService = RetrofitConfigurationService.getInstance(application).pizzaService()
    private var pizzaMapper = PizzaMapper.getInstance()

    fun getPizzaFromWeb() {
        pizzaWebService.getPizza(1).enqueue(object : Callback<PizzaDto?> {
            override fun onResponse(call: Call<PizzaDto?>, response: Response<PizzaDto?>) {
                if (response.isSuccessful) {
                    _pizza.value = pizzaMapper.mapToPizza(response.body())
                    _error.value = null
                } else {
                    _error.value = NetworkError.REQUEST_ERROR
                }
            }

            override fun onFailure(call: Call<PizzaDto?>, t: Throwable) {
                if (t is NoConnectivityException) {
                    _error.value = NetworkError.NO_CONNECTION
                } else {
                    _error.value = NetworkError.TECHNICAL_ERROR
                }
            }
        })
    }
}