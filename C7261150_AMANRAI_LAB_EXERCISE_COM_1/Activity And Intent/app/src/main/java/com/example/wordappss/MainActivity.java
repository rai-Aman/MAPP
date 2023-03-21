package com.example.wordappss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private boolean isVertical = true;
    private boolean isGrid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.LinearLay);
        updateLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_settings);
        ToggleButton tButton = (ToggleButton) item.getActionView();
        tButton.setText("");
        tButton.setBackgroundColor(Color.TRANSPARENT);
        tButton.setTextOff("");
        tButton.setTextOn("");
        StateListDrawable icon = new StateListDrawable();
        icon.addState(new int[]{android.R.attr.state_checked}, getResources().getDrawable(R.drawable.list));
        icon.addState(new int[]{}, getResources().getDrawable(R.drawable.grid));
        tButton.setButtonDrawable(icon);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected(item);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            ToggleButton tButton = item.getActionView().findViewById(R.id.action_settings);
            tButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        isGrid = true;
                        updateLayout();
                    } else {
                        isGrid = false;
                        updateLayout();
                    }
                }
            });
            // Handle the action
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateLayout() {
        if (isGrid) {
            layout.removeAllViews();
            layout.setOrientation(isVertical ? LinearLayout.VERTICAL : LinearLayout.HORIZONTAL);
            Intent intent = new Intent(this, SecondActivity.class);

            GridLayout gridLayout = new GridLayout(this);
            gridLayout.setColumnCount(4);
            gridLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            for (char c = 'a'; c <= 'z'; c++) {
                Button btn = new Button(this);
                btn.setText(String.valueOf(c));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("text", btn.getText().toString());
                        startActivity(intent);
                    }
                });
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                //params.setMargins(0, 0, 0, 0);
                gridLayout.addView(btn, params);
            }

            layout.addView(gridLayout);
        } else {
            layout.removeAllViews();
            Intent intent = new Intent(this, SecondActivity.class);
            for (char c = 'a'; c <= 'z'; c++) {
                Button btn = new Button(this);
                btn.setText(String.valueOf(c));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("text", btn.getText().toString());
                        startActivity(intent);
                    }
                });
                layout.addView(btn);
            }
        }
    }
}
