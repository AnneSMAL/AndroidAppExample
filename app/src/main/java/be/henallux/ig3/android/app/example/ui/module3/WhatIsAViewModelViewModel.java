package be.henallux.ig3.android.app.example.ui.module3;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * A ViewModel is a layer of the MVVM pattern and is responsible of : <br/>
 * - Holding variables values; <br/>
 * - Initializing variables; <br/>
 * - Handle BUSINESS logic of user events; <br/>
 * However, the ViewModel will never : <br/>
 * - Takes care of the navigation; <br/>
 * - Updates the UI; <br/>
 * A ViewModel is always associated to an activity or a fragment, and is living "with" this one (Meaning
 * if the fragment is fully destroyed, the ViewModel too)
 */
public class WhatIsAViewModelViewModel extends ViewModel {
    private static final String TAG = "WhatIsAViewModelVM";

    private MutableLiveData<Integer> _myCounter = new MutableLiveData<>(0);
    private LiveData<Integer> myCounter = _myCounter;

    void incrementCounter() {
        if (_myCounter.getValue() == null) {
            _myCounter.setValue(0);
        } else {
            _myCounter.setValue(_myCounter.getValue() + 1);
        }
    }

    /**
     * @return Live Data is similar to an Observable : The activity will "observe" the LiveData, to
     * make an action if any change happens.
     */
    LiveData<Integer> getMyCounter() {
        return myCounter;
    }

    /**
     * As activities and fragments, ViewModels also have their own lifecycle. However, this one
     * survives to configuration changes, in opposite of the two others. </br>
     * ViewModel does not survive Android silent kills either : You need a mix of ViewModel usage and
     * onSaveInstanceState.
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel is destroyed");
    }
}
