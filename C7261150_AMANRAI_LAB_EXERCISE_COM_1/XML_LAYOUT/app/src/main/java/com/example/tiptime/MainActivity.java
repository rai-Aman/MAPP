package com.example.tiptime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;

    RadioButton rb;
    EditText txtTip;
    TextView tvTip;
    Switch rtSwitch;

    private boolean roundUpIs = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = findViewById(R.id.rgTipAmount);
        Button btn = findViewById(R.id.calculateButton);
        txtTip = findViewById(R.id.costService);
        tvTip = findViewById(R.id.textViewAmount);
        rtSwitch = findViewById(R.id.roundTipSwitch);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double costOfService;
                double tipAmount;
                double tipPercentage = 0;


                if(txtTip.getText().toString().equals("")){
                    txtTip.setError("Enter Cost Of Service");
                    return;
                }
                int checkedId = rg.getCheckedRadioButtonId();
                if(checkedId<0){
                    rb.setError("Select Service Type");
                    return;
                }
                try{
                    costOfService = Double.valueOf(txtTip.getText().toString());
                }
                catch(Exception ex){
                    txtTip.setError("Invalid cost of Service");
                    return;
                }
                switch (checkedId){
                    case R.id.amazing:
                        tipPercentage = 0.20;
                        break;
                    case R.id.good:
                        tipPercentage = 0.18;
                        break;
                    case R.id.okay:
                        tipPercentage = 0.15;
                }
                rtSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            roundUpIs = true;
                        }
                        else{
                            roundUpIs = false;
                        }
                    }
                });
                if(roundUpIs){
                    tipAmount = costOfService * tipPercentage;
                    int roundTip = (int) Math.ceil(tipAmount);
                    tvTip.setText(Integer.toString(roundTip));
                }
                else {
                    tipAmount = costOfService * tipPercentage;
                    tvTip.setText(Double.toString(tipAmount));
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId){
                    case R.id.amazing:

                        Toast.makeText(getApplicationContext(), "Amazing clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.good:
                        Toast.makeText(getApplicationContext(), "Good clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.okay:
                        Toast.makeText(getApplicationContext(), "Okay clicked", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}