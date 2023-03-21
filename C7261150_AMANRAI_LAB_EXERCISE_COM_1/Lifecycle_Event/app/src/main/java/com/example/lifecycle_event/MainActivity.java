package com.example.lifecycle_event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "OnCreate Event Called");
        userName = findViewById(R.id.UserName);
        password = findViewById(R.id.pass);
        if(savedInstanceState != null){
            String name = savedInstanceState.getString("name");
            String passwords = savedInstanceState.getString("password");
            userName.setText(name);
            password.setText(passwords);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LifeCycle", "onSaveInstance event called");
        outState.putString("name", userName.getText().toString());
        outState.putString("password", password.getText().toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart Method Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "OnResume Event Called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "OnPause Event Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "OnStop Event Called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "OnDestroy Event Called");

    }
}