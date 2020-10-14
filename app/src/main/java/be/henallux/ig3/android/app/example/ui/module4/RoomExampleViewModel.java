package be.henallux.ig3.android.app.example.ui.module4;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.List;

import be.henallux.ig3.android.app.example.models.User;
import be.henallux.ig3.android.app.example.repositories.UserRepository;

public class RoomExampleViewModel extends AndroidViewModel {

    private MediatorLiveData<List<User>> mObservableUsers;
    private UserRepository mUserRepository;

    public RoomExampleViewModel(Application app) {
        super(app);
        mUserRepository = UserRepository.getInstance(app);
        mObservableUsers = new MediatorLiveData<>();
        mObservableUsers.addSource(mUserRepository.getObservableUsers(),mObservableUsers::setValue);
    }

    public LiveData<List<User>> getObservableUsers(){
        return mObservableUsers;
    }

    public void getUsers(){mUserRepository.getUsers();}
    public void addUsers(User... users){mUserRepository.addUsers(users);}
}

