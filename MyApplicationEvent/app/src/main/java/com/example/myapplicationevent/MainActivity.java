package com.example.myapplicationevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        EditText getText = findViewById(R.id.editTextTextPersonName);
        TextView textView = findViewById(R.id.textView);
        String name = String.valueOf(getText.getText());
        Toast toast = Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT);
        textView.setText(name);
        toast.show();
    }


}