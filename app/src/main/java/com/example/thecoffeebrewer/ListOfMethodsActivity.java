package com.example.thecoffeebrewer;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListOfMethodsActivity extends AppCompatActivity {

    private Integer methodId;
    private ListView mListView;
    private List<Recipe> listOfRecipes = new ArrayList<Recipe>();
    private String methodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_methods);

        methodName = getIntent().getStringExtra("methodName");
        Global global = new Global();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor c = databaseHelper.getMethodByData(methodName);

        Recipe topOfList = new Recipe(methodName, methodName); //dodawanie jako pierwszej karty z gory, karty z nazwa metody
        listOfRecipes.add(topOfList);

        if (c.getCount() == 0) {
            Log.e("ListOfMethodsActivity", "Datebase's cursor error!");
        } else {
            while (c.moveToNext()) {
                Recipe r = new Recipe(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6),
                        c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11));

                listOfRecipes.add(r);
            }
        }

        methodId = global.getMethodId(methodName);
        mListView = findViewById(R.id.ListView);
        CustomAdapter customAdapter = new CustomAdapter();
        mListView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listOfRecipes.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Utils utils = new Utils();
            View methodView;

            if (position == 0) {
                methodView = getLayoutInflater().inflate(R.layout.top_list_layout, null);

                ImageView tImageView = methodView.findViewById(R.id.toplistImageView);
                TextView tTextView = methodView.findViewById(R.id.toplistTextView);

                try {
                    tImageView.setImageResource(methodId);
                } catch (Exception e1) {
                    Log.e("ListOfMethodsActivity", "Top card's image view loading error!");
                }

                try {
                    tTextView.setText(methodName);
                } catch (Exception e2) {
                    Log.e("ListOfMethodsActivity", "Top card's text view loading error!");
                }
            } else {
                methodView = getLayoutInflater().inflate(R.layout.method_layout, null);

                ImageView background = methodView.findViewById(R.id.rectanglebackground);
                ImageView mImageView = methodView.findViewById(R.id.MethodImageView);
                TextView methodTextName = methodView.findViewById(R.id.MethodName);
                TextView methodTextCoffeeAmount = methodView.findViewById(R.id.CoffeeAmountText);
                TextView methodTextWaterAmount = methodView.findViewById(R.id.WaterAmountText);
                TextView methodTextTimeAmount = methodView.findViewById(R.id.TimeAmountText);
                TextView methodTextTemperature = methodView.findViewById(R.id.TemperatureText);

                try {
                    utils.setTransferRecipeListener(background, ListOfMethodsActivity.this, MethodActivity.class, listOfRecipes.get(position));
                /*DatabaseHelper databaseHelper = new DatabaseHelper(ListOfMethodsActivity.this);
                if(!databaseHelper.insertData("Logs_table", (listOfRecipes.get(position)).getMethod(), (listOfRecipes.get(position)).getName(), (listOfRecipes.get(position)).getAmountOfWater(),
                        (listOfRecipes.get(position)).getAmountOfTime(), (listOfRecipes.get(position)).getAmountOfCoffee(), (listOfRecipes.get(position)).getTemperature(), (listOfRecipes.get(position)).getGrindSize(),
                        (listOfRecipes.get(position)).getTableOfGraphics(), (listOfRecipes.get(position)).getTableOfInstructions(), (listOfRecipes.get(position)).getTableOfTime(), (listOfRecipes.get(position)).getIsfavourite()))
                {
                    System.out.println("Adding to logs error!");
                }*/ // dodawania do logow
                } catch (Exception e1) {
                    Log.e("ListOfMethodsActivity", "Background image loading error!");
                }

                try {
                    mImageView.setImageResource(methodId);
                } catch (Exception e2) {
                    Log.e("ListOfMethodsActivity", "Method's image loading error!");
                }

                try {
                    methodTextName.setText((listOfRecipes.get(position)).getName());
                } catch (NullPointerException e3) {
                    Log.e("ListOfMethodsActivity", "Method's name loading error!");
                }

                try {
                    methodTextCoffeeAmount.setText((listOfRecipes.get(position)).getAmountOfCoffee());
                } catch (NullPointerException e4) {
                    Log.e("ListOfMethodsActivity", "Method's amount of coffee loading error!");
                }

                try {
                    methodTextWaterAmount.setText((listOfRecipes.get(position)).getAmountOfWater());
                } catch (NullPointerException e5) {
                    Log.e("ListOfMethodsActivity", "Method's amount of water loading error!");
                }

                try {
                    methodTextTimeAmount.setText((listOfRecipes.get(position)).getAmountOfTime());
                } catch (NullPointerException e6) {
                    Log.e("ListOfMethodsActivity", "Method's amount of time loading error!");
                }

                try {
                    methodTextTemperature.setText((listOfRecipes.get(position)).getTemperature());
                } catch (NullPointerException e6) {
                    Log.e("ListOfMethodsActivity", "Method's temperature loading error!");
                }
            }

            return methodView;
        }
    }

}