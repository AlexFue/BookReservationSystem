package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private Button submit;
    private Button back;
    private ReservationSystemDb db;
    private User found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        db = ReservationSystemDb.getInstance(this);

        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_username = findViewById(R.id.et_username);
                EditText et_password = findViewById(R.id.et_password);
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                found = db.user().findUserByUsername(username);

                if(found != null && found.getUsername().equals("!admin2") && found.getPassword().equals("!admin2")){
                    Intent i = new Intent(AdminLoginActivity.this, LogsActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(AdminLoginActivity.this, "Error! Incorrect Credentials", Toast.LENGTH_LONG).show();
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