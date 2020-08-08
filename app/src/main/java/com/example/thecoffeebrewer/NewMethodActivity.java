package com.example.thecoffeebrewer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewMethodActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NumberPicker.OnValueChangeListener {

    private String methodName;
    private TextView methodNameTextView;
    private ImageView methodImageView;
    private NumberPicker waterNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_method);

        Spinner methodNameSpinner = findViewById(R.id.newMethodNameSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.methods, android.R.layout.simple_spinner_item);
        waterNumberPicker = findViewById(R.id.waterNumberPicker);
        waterNumberPicker.setMinValue(1);
        waterNumberPicker.setMaxValue(500);
        waterNumberPicker.setOnValueChangedListener(this);


        methodNameTextView = findViewById(R.id.newMethodMethodName);
        methodImageView = findViewById(R.id.newMethodMethodImage);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        methodNameSpinner.setAdapter(arrayAdapter);
        methodNameSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        methodName = parent.getItemAtPosition(position).toString();

        try {
            methodNameTextView.setText(methodName);
        } catch (Exception e1) {
            Log.e("NewMethodActivity", "New method method's setting failure!");
        }

        try {
            Global global = new Global();
            Integer imgID = global.getMethodId(methodName);
            methodImageView.setImageResource(imgID);
        } catch (Exception e2) {
            Log.e("NewMethodActivity", "New method's image setting failure!");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }
}