package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private Button select;
    private Button back;  //***** SOMETHING WRONG, not ignoring books that are unavailable

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

        sp_genre.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected_genre = (String) sp_genre.getSelectedItem();

                titles = db.book().getAllTitlesByGenre(selected_genre);
                sp_title = findViewById(R.id.sp_title);
                ad_titles = new ArrayAdapter<>(PlaceHoldActivity.this, android.R.layout.simple_spinner_item, titles);
                ad_titles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_title.setAdapter(ad_titles);

                if(titles.size() < 1){
                    Toast.makeText(PlaceHoldActivity.this, "There are currently no available books for this genre", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        select = findViewById(R.id.btn_select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected_title = (String) sp_title.getSelectedItem();
                if(selected_title != null){
                    Book b = db.book().findBookByTitle(selected_title);
                    Intent i = new Intent( PlaceHoldActivity.this, LoginToHoldActivity.class);
                    Bundle bun = new Bundle();
                    bun.putInt("book_id", b.getBookId());
                    bun.putString("book_title", b.getTitle());
                    bun.putString("book_author", b.getAuthor());
                    bun.putString("book_genre", b.getGenre());
                    i.putExtras(bun);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(PlaceHoldActivity.this, "Please Select Book Title", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}