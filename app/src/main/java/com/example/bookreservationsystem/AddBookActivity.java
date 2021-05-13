package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    private Button add;
    private Button back;
    private EditText title;
    private EditText author;
    private EditText genre;
    private ReservationSystemDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        db = ReservationSystemDb.getInstance(this);

        add = findViewById(R.id.btn_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = findViewById(R.id.et_title);
                author = findViewById(R.id.et_author);
                genre = findViewById(R.id.et_genre);
                String s_title = title.getText().toString();
                String s_author = author.getText().toString();
                String s_genre = genre.getText().toString();

                AlertDialog.Builder alert = new AlertDialog.Builder(AddBookActivity.this);
                alert.setTitle("Is the Book Information Correct? " + System.lineSeparator() + s_title + " by: " + s_author + ", genre: " + s_genre);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Book new_book = new Book(s_title, s_author, s_genre, "available");
                        db.book().addBook(new_book);

                        Toast.makeText(AddBookActivity.this, "Successfully Add Book!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AddBookActivity.this.finish();
                            }
                        }, 2000);
                    }
                });

                alert.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(AddBookActivity.this, "Reenter correct fields", Toast.LENGTH_SHORT).show();
                            }
                        });

                alert.show();


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