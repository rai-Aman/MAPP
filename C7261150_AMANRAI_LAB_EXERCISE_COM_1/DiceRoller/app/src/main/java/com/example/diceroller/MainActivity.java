package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.roll_dice);
        TextView tv = findViewById(R.id.textView2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                tv.setText(Integer.toString(roll_dice()));

            }

        });
    }

    private int roll_dice() {
        Random random = new Random();
        int diceValue = random.nextInt(6);
        diceValue += 1;
        return diceValue;
    }
}