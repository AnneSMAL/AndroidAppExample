package be.henallux.ig3.android.app.example.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.room.Room;

import java.util.List;

import be.henallux.ig3.android.app.example.models.User;

/**
 * Create a Repository, with a MediatorLiveData
 */
public class UserRepository {

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<User>> mObservableUsers;

    /**
     * UserRepository as singleton
     */
    public static UserRepository getInstance(Context context) {
        AppDatabase mDatabase = Room.databaseBuilder(context, AppDatabase.class, "userdatabase")
                .build();
        return new UserRepository(mDatabase);
    }

    private UserRepository(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;

        /**
         * In the constructor, bind the DAO’s LiveData to the MediatorLiveData
         */
        mObservableUsers = new MediatorLiveData<>();
        mObservableUsers.addSource(mDatabase.userDao().getAllUsers(),
                mObservableUsers::postValue);
    }


    public LiveData<List<User>> getObservableUsers(){
        return mObservableUsers;
    }

    public void getUsers(){mDatabase.userDao().getAllUsers();}
    public void addUsers(User... users){mDatabase.userDao().insertUsers(users);}
}

