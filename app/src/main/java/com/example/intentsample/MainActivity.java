package com.example.intentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cmdSetAlarm;
    EditText txtHour, txtMinute, txtMessage;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdSetAlarm = findViewById(R.id.cmdSetAlarm);
        txtHour = findViewById(R.id.txtHour);
        txtMinute = findViewById(R.id.txtMinute);
        txtMessage = findViewById( R.id.txtMessage);

        cmdSetAlarm.setOnClickListener(setAlarm);
    }

    View.OnClickListener setAlarm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int hour = Integer.parseInt(txtHour.getText().toString());
            int min = Integer.parseInt(txtMinute.getText().toString());
            String msg = txtMessage.getText().toString();

            createAlarm(hour, min, msg);

            /*Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();*/
        }
    };

    private void createAlarm(int hour, int min, String msg) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, msg)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, min);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}