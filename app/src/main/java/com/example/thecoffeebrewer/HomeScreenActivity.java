package com.example.thecoffeebrewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils utils = new Utils();

        ImageButton BlackCoffeeButton = findViewById(R.id.BlackCoffeeButton);
        ImageButton NewMethodButton = findViewById(R.id.NewMethodButton);
        ImageButton FavouritesButton = findViewById(R.id.FavouritesButton);
        ImageButton WhiteCoffeeButton = findViewById(R.id.WhiteCoffeeButton);
        ImageButton DessertCoffeeButton = findViewById(R.id.DessertCoffeeButton);
        ImageButton LogsButton = findViewById(R.id.LogsButton);
        ImageButton SettingsButton = findViewById(R.id.SettingsButton);

        utils.setGoToListener(BlackCoffeeButton, HomeScreenActivity.this, BlackCoffeeActivity.class);
        utils.setGoToListener(NewMethodButton, HomeScreenActivity.this, NewMethodActivity.class);
        utils.setGoToListener(FavouritesButton, HomeScreenActivity.this, FavouritesActivity.class);
        utils.setGoToListener(WhiteCoffeeButton, HomeScreenActivity.this, WhiteCoffeeActivity.class);
        utils.setGoToListener(DessertCoffeeButton, HomeScreenActivity.this, DessertCoffeeActivity.class);
        utils.setGoToListener(LogsButton, HomeScreenActivity.this, LogsActivity.class);
        utils.setGoToListener(SettingsButton, HomeScreenActivity.this, SettingsActivity.class);
    }
}