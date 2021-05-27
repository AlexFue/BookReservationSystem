package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    private ReservationSystemDb db;
    private Button create;
    private User found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        db = ReservationSystemDb.getInstance(this);

        create = findViewById(R.id.btn_create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_username = findViewById(R.id.et_username);
                EditText et_password = findViewById(R.id.et_password);
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                boolean empty = isEmpty(username, password);
                boolean valid = isValid(username, password);

                if(empty || !valid){
                    Toast.makeText(CreateAccountActivity.this, "Error! Make username unique & fill out all fields", Toast.LENGTH_LONG).show();
                }
                else{
                    Log new_log = new Log("New Account: " + username);
                    db.log().addLog(new_log);

                    User new_user = new User(username, password);
                    db.user().addUser(new_user);

                    Toast.makeText(CreateAccountActivity.this, "Successfully Created Account!", Toast.LENGTH_LONG).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CreateAccountActivity.this.finish();
                    }
                }, 3000);
            }
        });

        View backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean isValid(String username, String password) {
        found = db.user().findUserByUsername(username);

        // if empty, username is not valid
        if(found == null){
            return true;
        }
        else if(username.equals("!admin2")){
            return false;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(String username, String password){
        if(username.equals("") || password.equals("")){
            return true;
        }
        return false;
    }
}