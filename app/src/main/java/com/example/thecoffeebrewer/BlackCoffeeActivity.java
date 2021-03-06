package com.example.thecoffeebrewer;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BlackCoffeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_coffee);

        Utils utils = new Utils();

        ImageButton aeropressButton = findViewById(R.id.aeropress);
        ImageButton hariov60Button = findViewById(R.id.hariov60);
        ImageButton frenchpressButton = findViewById(R.id.frenchpress);
        ImageButton chemexButton = findViewById(R.id.chemex);
        ImageButton cuppingButton = findViewById(R.id.cupping);
        ImageButton kalitaButton = findViewById(R.id.kalita);
        ImageButton mokapotButton = findViewById(R.id.mokapot);

        utils.setTransferNameListener(aeropressButton, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "Aeropress");
        utils.setTransferNameListener(hariov60Button, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "Hario V60");
        utils.setTransferNameListener(frenchpressButton, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "French Press");
        utils.setTransferNameListener(chemexButton, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "Chemex");
        utils.setTransferNameListener(cuppingButton, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "Cupping");
        utils.setTransferNameListener(kalitaButton, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "Kalita");
        utils.setTransferNameListener(mokapotButton, BlackCoffeeActivity.this, ListOfMethodsActivity.class, "Moka pot");
    }
}