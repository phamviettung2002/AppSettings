package com.example.appsetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnblack, btnred, btnblue, btngreen, btncount, btnreset;
    TextView txtshow;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnblack = findViewById(R.id.btnBlack);
        btnred = findViewById(R.id.btnRed);
        btnblue = findViewById(R.id.btnBlue);
        btngreen = findViewById(R.id.btnGreen);
        btncount = findViewById(R.id.btnCount);
        btnreset = findViewById(R.id.btnReset);
        txtshow = findViewById(R.id.txtShow);

        btnblack.setOnClickListener(click);
        btnred.setOnClickListener(click);
        btnblue.setOnClickListener(click);
        btngreen.setOnClickListener(click);
        btnreset.setOnClickListener(click);
        btncount.setOnClickListener(click);

//        PreferenceManager.setDefaultValues(this, R.layout.activity_main, false);
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        int destinationPrefblack = sharedPreferences.getInt("keyBlack", Color.BLACK );

        sharedPreferences = getSharedPreferences("Save", MODE_PRIVATE);
        txtshow.setText(sharedPreferences.getInt("count", 0)+"");
        if (sharedPreferences.getInt("color", 0)!= 0 ){
            txtshow.setBackgroundColor(sharedPreferences.getInt("color", 0));
        }

    }
    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
SharedPreferences.Editor editor  = sharedPreferences.edit();


            switch (view.getId()){
                case R.id.btnBlack:
                    txtshow.setBackgroundColor(Color.BLACK);
                    editor.putInt("color", Color.BLACK);
                    editor.commit();
                    break;
                case R.id.btnRed:
                    txtshow.setBackgroundColor(Color.RED);
                    editor.putInt("color", Color.RED);
                    editor.commit();
                    break;
                case R.id.btnBlue:
                    txtshow.setBackgroundColor(Color.BLUE);
                    editor.putInt("color", Color.BLUE);
                    editor.commit();
                    break;
                case R.id.btnGreen:
                    txtshow.setBackgroundColor(Color.GREEN);
                    editor.putInt("color", Color.GREEN);
                    editor.commit();
                    break;
                case R.id.btnCount:
                    int tempt = Integer.parseInt(txtshow.getText().toString()) + 1;
                    txtshow.setText(String.valueOf(tempt));
                    editor.putInt("count", tempt);
                    editor.commit();
                    break;

                case R.id.btnReset:
                    txtshow.setBackgroundColor(0);
                    txtshow.setText("0");
                    editor.putInt("count", 0);
                    editor.putInt("color", 0);
                    editor.commit();
                    break;
            }
        }
    };
}