package be.henallux.ig3.android.app.example.ui.module3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataBindingViewModel extends ViewModel {
    private MutableLiveData<Integer> _dataBindingCounter = new MutableLiveData<>(0);
    private LiveData<Integer> dataBindingCounter = _dataBindingCounter;

    private MutableLiveData<Integer> _finalCounter = new MutableLiveData<>();
    private LiveData<Integer> finalCounter = _finalCounter;

    public void incrementCounter() {
        if (_dataBindingCounter.getValue() == null) {
            _dataBindingCounter.setValue(0);
        } else {
            _dataBindingCounter.setValue(_dataBindingCounter.getValue() + 1);
        }
    }

    /**
     * @return Live Data is similar to an Observable : The activity will "observe" the LiveData, to
     * make an action if any change happens.
     */
    public LiveData<Integer> getDataBindingCounter() {
        return dataBindingCounter;
    }

    public LiveData<Integer> getFinalCounter() {
        return finalCounter;
    }

    public void fixCounter() {
        this._finalCounter.setValue(_dataBindingCounter.getValue());
    }
}
