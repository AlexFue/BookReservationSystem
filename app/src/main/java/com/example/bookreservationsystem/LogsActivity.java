package com.example.bookreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LogsActivity extends AppCompatActivity {

    private Button ok;
    private ReservationSystemDb db;
    private TextView messages;
    List<Log> logs = new ArrayList<Log>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        db = ReservationSystemDb.getInstance(this);
        messages = findViewById(R.id.tv_messages);
        logs = db.log().getAllLogs();

        if(logs.size() > 0){
            messages.setText("");
            for(int i = 0; i < logs.size(); i++){
                messages.setText(messages.getText() + System.lineSeparator() + logs.get(i).getMessage());
            }
        }
        else{
            messages.setText("There are currently no available logs");
        }



        ok = findViewById(R.id.btn_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogsActivity.this, AskToAddBookActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}