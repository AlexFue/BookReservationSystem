package com.example.bookreservationsystem;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.GregorianCalendar;

@Database(entities = {User.class, Book.class, Log.class}, version = 9, exportSchema = false)
public abstract class ReservationSystemDb extends RoomDatabase {

    private static ReservationSystemDb sInstance;
    public abstract UserDao user();
    public abstract BookDao book();
    public abstract LogDao log();

    public static synchronized ReservationSystemDb getInstance(Context context){
        if(sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    ReservationSystemDb.class,
                    "reservationsystem.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void seed() { // prepopulating database with some users and books
        if (user().count() == 0) {
            User admin = new User("!admin2", "!admin2");
            User alex = new User("alex", "123");
            User anton = new User("anton", "t3nn1sch@mp2021");
            User bernie = new User("bernie", "k3ralaf@n");
            User shirleybee = new User("shirleybee", "carmel2chicago");
            long[] user_ids = user().insertUsers(admin, alex, anton, bernie, shirleybee);
        }
        if (book().count() == 0) {
            Book b1 = new Book("Kitchen Confidential", "Anthonyj Bourdain", "Memoir", "available");
            Book b2 = new Book("The IDA Pro Book", "Chris Eagle", "Computer Science", "available");
            Book b3 = new Book("Frankenstein", "Mary Shelley", "Fiction", "available");
            long[] book_ids = book().insertBooks(b1, b2, b3);
        }
    }

}
