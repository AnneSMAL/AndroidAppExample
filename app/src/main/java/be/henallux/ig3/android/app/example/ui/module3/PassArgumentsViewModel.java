package be.henallux.ig3.android.app.example.ui.module3;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PassArgumentsViewModel extends ViewModel {
    private MutableLiveData<Integer> _previousCounter = new MutableLiveData<>(0);
    private LiveData<Integer> previousCounter = _previousCounter;

    private PassArgumentsViewModel(Integer previousCounter) {
        this._previousCounter.setValue(previousCounter);
    }

    public LiveData<Integer> getPreviousCounter() {
        return previousCounter;
    }

    /**
     * Custom ViewModelProperty.Factory to pass arguments to the associated ViewModel.
     */
    public static class Factory implements ViewModelProvider.Factory {
        private Integer previousCounter;

        Factory(Integer previousCounter) {
            this.previousCounter = previousCounter;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(PassArgumentsViewModel.class)) {
                return (T) new PassArgumentsViewModel(previousCounter);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
