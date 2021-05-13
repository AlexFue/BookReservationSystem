package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class LoginToHoldActivity extends AppCompatActivity {

    private Bundle bun;
    private Button login;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_hold);

        bun = getIntent().getExtras();
        Toast.makeText(LoginToHoldActivity.this, bun.getInt("book_id") + bun.getString("book_title"), Toast.LENGTH_LONG).show();

    }
}