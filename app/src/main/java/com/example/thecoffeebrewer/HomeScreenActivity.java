package com.example.thecoffeebrewer;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test bazy danych
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        //databaseHelper.deleteDataBase("Recipes_table");
        databaseHelper.insertData("Recipes_table", "Aeropress", "Przepis 1", "250g", "2:30", "15g", "98C", "medium-fine", "1;2;5", "Do this;Do that", "0:15;0:30", "false");
        databaseHelper.insertData("Recipes_table", "Hario V60", "Fav method", "280g", "2:50", "11g", "100C", "medium-fine", "1;2;5", "Do this;Do that", "0:15;0:30", "true");
        databaseHelper.insertData("Recipes_table", "Aeropress", "Przepis 2", "250g", "2:30", "13g", "98C", "medium-fine", "1;2;5", "Do this;Do that", "0:15;0:30", "false");
        databaseHelper.insertData("Recipes_table", "Aeropress", "Przepis 3", "300g", "2:30", "17g", "98C", "medium-fine", "1;2;5", "Do this;Do that", "0:15;0:30", "false");

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