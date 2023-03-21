package com.example.wordappss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String Letter = getIntent().getStringExtra("text");
        // Get the words corresponding to the letter from array.xml

        int resId = getResources().getIdentifier(Letter, "array", getPackageName());
        String[] words = getResources().getStringArray(R.array.words);
        LinearLayout layout = findViewById(R.id.LinearLays);


        // Create buttons for each word
        for (String word : words) {
            if (word.toLowerCase().startsWith(Letter.toLowerCase())) {

                Button btn = new Button(this);
                btn.setText(word);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Open a Google search page for the word
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.google.com/search?q=" + word));
                        startActivity(intent);
                    }
                });
                layout.addView(btn);
            }
        }
    }
}