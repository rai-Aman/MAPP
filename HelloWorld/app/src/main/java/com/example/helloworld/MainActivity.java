package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Log: The Log class for sending log messages to the Logcat pane.
        d: The Debug Log level setting to filter log message display in the Logcat pane. Other log levels are e for Error, w for Warn, and i for Info.
        "MainActivity": The first argument is a tag which can be used to filter messages in the Logcat pane. This is commonly the name of the Activity from which the message originates. However, you can make this anything*/

        Log.d("MainActivity", "Hello World");
        Log.w("MainActivity", "This is warning");
    }
}