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

public class LoginToHoldActivity extends AppCompatActivity {

    private Bundle bun;
    private Button login;
    private Button back;
    private ReservationSystemDb db;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_hold);

        db = ReservationSystemDb.getInstance(this);
        bun = getIntent().getExtras();

        login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = findViewById(R.id.et_username);
                password = findViewById(R.id.et_password);
                String u = username.getText().toString();
                String p = password.getText().toString();
                boolean valid = valid(u, p);
                if(valid){
                    int reservation_num = db.log().count() + 1 + 9000;
                    Log new_log = new Log("Place Hold. Username: " + u + " Reservation Number: " + Integer.toString(reservation_num));
                    db.log().addLog(new_log);

                    db.book().setAvailability(bun.getInt("book_id"));

                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginToHoldActivity.this);
                    alert.setMessage("Customer username: " + u + System.lineSeparator() + "Book Title: " + bun.getString("book_title") + System.lineSeparator() + "Reservation Number: " + reservation_num);
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            Toast.makeText(LoginToHoldActivity.this, "Placed Hold on Book!", Toast.LENGTH_LONG).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    LoginToHoldActivity.this.finish();
                                }
                            }, 2000);
                        }
                    });
                    alert.show();

//                    Toast.makeText(LoginToHoldActivity.this, "Placed Hold on Book!", Toast.LENGTH_LONG).show();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            LoginToHoldActivity.this.finish();
//                        }
//                    }, 3000);
                }
                else{

                    Toast.makeText(LoginToHoldActivity.this, "Credential Incorrect", Toast.LENGTH_LONG).show();
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

    public boolean valid(String username, String password){
        User u = db.user().findUserByUsername(username);
        if(u != null && u.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}