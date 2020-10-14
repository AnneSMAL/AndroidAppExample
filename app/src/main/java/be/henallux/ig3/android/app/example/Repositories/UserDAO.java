package be.henallux.ig3.android.app.example.repositories;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import be.henallux.ig3.android.app.example.models.User;

/**
 * A DAO is an interface for CRUD operations
 * Each entity has its own DAO
 * Write common queries that you need (Useless to fill all your DAOs with every CRUD operation if you don’t use them …)
 */
@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    //return LiveData
    @Query("SELECT * FROM user")
    public LiveData<List<User>> getAllUsers();


}

