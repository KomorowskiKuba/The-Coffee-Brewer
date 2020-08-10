package com.example.thecoffeebrewer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class NewMethodActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NumberPicker.OnValueChangeListener {

    private String methodName;
    private TextView methodNameTextView;
    private TextView grindSizeTextView;
    private TextView waterAmountTextView;
    private TextView coffeeAmountTextView;
    private TextView temperatureAmountTextView;
    private TextView timeAmountTextView;
    private ImageView methodImageView;
    private Button addRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_method);

        Spinner methodNameSpinner = findViewById(R.id.newMethodNameSpinner);
        Spinner grindSizeSpinner = findViewById(R.id.newMethodGrindSizeSpinner);
        ArrayAdapter<CharSequence> nameAdapter = ArrayAdapter.createFromResource(this, R.array.methods, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> grindSizeAdapter = ArrayAdapter.createFromResource(this, R.array.grindSizes, android.R.layout.simple_spinner_item);

        methodNameTextView = findViewById(R.id.newMethodMethodName);
        waterAmountTextView = findViewById(R.id.waterNumberPicker);
        coffeeAmountTextView = findViewById(R.id.coffeeNumberPicker);
        temperatureAmountTextView = findViewById(R.id.temperatureNumberPicker);
        timeAmountTextView = findViewById(R.id.timeNumberPicker);
        grindSizeTextView = findViewById(R.id.grindSizePicker);

        methodImageView = findViewById(R.id.newMethodMethodImage);
        addRecipeButton = findViewById(R.id.addRecipeButton);

        nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        methodNameSpinner.setAdapter(nameAdapter);
        methodNameSpinner.setOnItemSelectedListener(this);

        grindSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grindSizeSpinner.setAdapter(grindSizeAdapter);
        grindSizeSpinner.setOnItemSelectedListener(this);

        addRecipeButton.setOnClickListener(e -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            String name = methodNameTextView.getText().toString();
            String water = waterAmountTextView.getText().toString();
            String time = timeAmountTextView.getText().toString();
            String coffee = coffeeAmountTextView.getText().toString();
            String temperature = temperatureAmountTextView.getText().toString();
            String grind = grindSizeTextView.getText().toString();

            if (name.length() == 0 || water.length() == 0 || coffee.length() == 0 || temperature.length() == 0 || grind.length() == 0) {
                Toast mToastToShow = Toast.makeText(this, "Fill all of the informations!", Toast.LENGTH_LONG);
                mToastToShow.show();
            } else {
                databaseHelper.insertData("Recipes_table", methodName, name, water, time, coffee, temperature, grind, "1;2;3", "1;2;3", "1;2;3", "false");
                NewMethodActivity.this.finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        methodName = parent.getItemAtPosition(position).toString();

        switch (parent.getId()) {

            case R.id.newMethodNameSpinner:
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
                break;
            case R.id.newMethodGrindSizeSpinner:
                try {
                    grindSizeTextView.setText(methodName);
                } catch (Exception e3) {
                    Log.e("NewMethodActivity", "New method grind size's setting failure!");
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }
}