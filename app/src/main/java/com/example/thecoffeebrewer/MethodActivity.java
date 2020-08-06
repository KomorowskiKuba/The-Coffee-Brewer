package com.example.thecoffeebrewer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);

        Utils utils = new Utils();
        Global global = new Global();
        Intent intent = getIntent();
        Recipe recipe = intent.getParcelableExtra("Recipe");

        ImageView imageView = findViewById(R.id.MethodImageView);
        TextView recipeName = findViewById(R.id.RecipeName);
        TextView recipeCoffeeAmount = findViewById(R.id.CoffeeAmountText);
        TextView recipeWaterAmount = findViewById(R.id.WaterAmountText);
        TextView recipeTimeAmount = findViewById(R.id.TimeAmountText);
        TextView recipeTemperature = findViewById(R.id.TemperatureAmountText);
        TextView recipeGrindSize = findViewById(R.id.GrindSizeText);
        TextView recipeRatio = findViewById(R.id.RatioText);

        int currentRatio = utils.extractGrams(recipe.getAmountOfWater()) / utils.extractGrams(recipe.getAmountOfCoffee());
        String currentRatioString = "1:" + currentRatio;

        recipeRatio.setText(currentRatioString);
        imageView.setImageResource((Integer) (global.getMethodId(recipe.getMethod())));
        recipeName.setText(recipe.getName());
        recipeCoffeeAmount.setText(recipe.getAmountOfCoffee());
        recipeWaterAmount.setText(recipe.getAmountOfWater());
        recipeTimeAmount.setText(recipe.getAmountOfTime());
        recipeTemperature.setText(recipe.getTemperature());
        recipeGrindSize.setText(recipe.getGrindSize());

        /*DatabaseHelper databaseHelper = new DatabaseHelper(this);
        if(!databaseHelper.insertData("Logs_table", recipe.getMethod(), recipe.getName(), recipe.getAmountOfWater(),
                recipe.getAmountOfTime(), recipe.getAmountOfCoffee(), recipe.getTemperature(), recipe.getGrindSize(),
                recipe.getTableOfGraphics(), recipe.getTableOfInstructions(), recipe.getTableOfTime(), recipe.getIsfavourite()))
        {
            System.out.println("Adding to logs error!");
        }
        */ // To dodaje do logów

    }
}