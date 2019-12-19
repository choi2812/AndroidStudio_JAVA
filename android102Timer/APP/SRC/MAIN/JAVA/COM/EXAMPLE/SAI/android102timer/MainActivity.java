package com.example.sai.android102timer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private long time=0;
    public void onClickAction(View view){
        Chronometer chronometer=(Chronometer)findViewById(R.id.chronometer);
        Button btnStart=(Button)findViewById(R.id.btnStart);
        Button btnStop=(Button)findViewById(R.id.btnStop);
        Button btnReset=(Button)findViewById(R.id.btnReset);

        if(view.getId()==R.id.btnStart){
            chronometer.setBase(SystemClock.elapsedRealtime()-time);
            chronometer.start();
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            btnReset.setEnabled(false);
        }else if(view.getId()==R.id.btnStop){
            btnStart.setEnabled(false);
            btnReset.setEnabled(true);
            btnStop.setEnabled(false);
            chronometer.stop();
            time=SystemClock.elapsedRealtime() - chronometer.getBase();
        }else if(view.getId()==R.id.btnReset){
            btnStart.setEnabled(true);
            btnReset.setEnabled(false);
            btnStop.setEnabled(false);
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime());
            time=0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
