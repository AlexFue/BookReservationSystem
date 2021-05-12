package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ReservationSystemDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = ReservationSystemDb.getInstance(this);
        db.seed();

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
                Intent i = new Intent(this, CreateAccount.class);
                startActivity(i);
                break;
            case R.id.btn_place_hold:
                break;
            case R.id.btn_manage_system:
                break;
            default:
                break;
        }

    }


}