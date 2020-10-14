package be.henallux.ig3.android.app.example.repositories;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import be.henallux.ig3.android.app.example.models.User;

/**
 * Putting everything together : Declare an abstract class to hold all the DAOs (Database)
 *
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    // list here all the DAO
    public abstract UserDAO userDao();
}
