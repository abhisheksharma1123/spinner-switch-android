package com.example.demorun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    int Price;
    private TextView result;
    private TextView outcome;
    private Spinner spinner;
    private ConstraintLayout constraintLayout;
    private Switch switch1;
    String[] str = {"good", "dislike", "like", "hate", "moderate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        outcome = findViewById(R.id.outcome);
//        ========================Switch======================
        constraintLayout = findViewById(R.id.constraintLayout);
        switch1 = findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                   constraintLayout.setBackgroundColor(Color.CYAN);
                }
                else{
                    constraintLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
// ====================================================================

// ===============================Spinner==============================
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, str);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


// inside the onCreate
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        result.setText(adapterView.getItemAtPosition(i).toString());
        String val = result.getText().toString();
       if(val.equals("good")){
            Price = 12;
            outcome.setText("jasmeet the price is " + val + " " + Price);
        }
       else {
           Price = 13;
           outcome.setText("jasmeet the price is" + " " + Price);
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        result.setText("please select an item");
    }
//================================================================================

    

}