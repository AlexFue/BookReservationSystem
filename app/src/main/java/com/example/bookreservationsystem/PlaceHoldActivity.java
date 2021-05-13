package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.List;

public class PlaceHoldActivity extends AppCompatActivity {

    private ReservationSystemDb db;
    private Spinner sp_genre;
    private Spinner sp_title;
    private List<String> genres;
    private List<String> titles;
    private ArrayAdapter<String> ad_genres;
    private ArrayAdapter<String> ad_titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_hold);
        db = ReservationSystemDb.getInstance(this);

        genres = db.book().getAllGenres();
        sp_genre = findViewById(R.id.sp_genre);
        ad_genres = new ArrayAdapter<>(PlaceHoldActivity.this, android.R.layout.simple_spinner_item, genres);
        ad_genres.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_genre.setAdapter(ad_genres);

//        String selected_genre = (String) sp_genre.getSelectedItem();
//        titles = db.book().getAllTitlesByGenre(selected_genre);
//        if(titles.size() > 0){
//
//        }
//        else{
//            Toast.makeText(PlaceHoldActivity.this, "There are currently no available books for this genre", Toast.LENGTH_LONG).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    PlaceHoldActivity.this.finish();
//                }
//            }, 3000);
//        }
    }
}