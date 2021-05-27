package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ReservationSystemDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = ReservationSystemDb.getInstance(this);
        db.seed();

//        Button create = findViewById(R.id.btn_create_account);
//        create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(this, CreateAccountActivity.class);
//                startActivity(i);
//            }
//        });

        View create_account = findViewById(R.id.btn_create_account);
        create_account.setOnClickListener(this);

        View place_hold = findViewById(R.id.btn_place_hold);
        place_hold.setOnClickListener(this);

        View manage_system = findViewById(R.id.btn_manage_system);
        manage_system.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_create_account:
                Intent i = new Intent(this, CreateAccountActivity.class);
                startActivity(i);
                break;
            case R.id.btn_place_hold:
                Intent j = new Intent(this, PlaceHoldActivity.class);
                startActivity(j);
                break;
            case R.id.btn_manage_system:
                Intent k = new Intent(this, AdminLoginActivity.class);
                startActivity(k);
                break;
            default:
                break;
        }
    }
}