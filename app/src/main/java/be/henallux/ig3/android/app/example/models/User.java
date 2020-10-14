package be.henallux.ig3.android.app.example.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * Each entity is materialized by a class (1 entity = 1 SQL table)
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

