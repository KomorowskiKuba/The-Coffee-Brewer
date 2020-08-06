package com.example.thecoffeebrewer;

import android.database.Cursor;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_methods);

        String methodName = getIntent().getStringExtra("methodName");
        Global global = new Global();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor c = databaseHelper.getMethodByData(methodName);

        if (c.getCount() == 0) {
            System.out.println("Cursor's error!");
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

            View view = getLayoutInflater().inflate(R.layout.method_layout, null);
            Utils utils = new Utils();

            ImageView background = view.findViewById(R.id.rectanglebackground);
            ImageView mImageView = view.findViewById(R.id.MethodImageView);
            TextView methodTextName = view.findViewById(R.id.MethodName);
            TextView methodTextCoffeeAmount = view.findViewById(R.id.CoffeeAmountText);
            TextView methodTextWaterAmount = view.findViewById(R.id.WaterAmountText);
            TextView methodTextTimeAmount = view.findViewById(R.id.TimeAmountText);
            TextView methodTextTemperature = view.findViewById(R.id.TemperatureText);

            try {
                utils.setTransferRecipeListener(background, ListOfMethodsActivity.this, MethodActivity.class, listOfRecipes.get(position));
                /*DatabaseHelper databaseHelper = new DatabaseHelper(ListOfMethodsActivity.this);
                if(!databaseHelper.insertData("Logs_table", (listOfRecipes.get(position)).getMethod(), (listOfRecipes.get(position)).getName(), (listOfRecipes.get(position)).getAmountOfWater(),
                        (listOfRecipes.get(position)).getAmountOfTime(), (listOfRecipes.get(position)).getAmountOfCoffee(), (listOfRecipes.get(position)).getTemperature(), (listOfRecipes.get(position)).getGrindSize(),
                        (listOfRecipes.get(position)).getTableOfGraphics(), (listOfRecipes.get(position)).getTableOfInstructions(), (listOfRecipes.get(position)).getTableOfTime(), (listOfRecipes.get(position)).getIsfavourite()))
                {
                    System.out.println("Adding to logs error!");
                }*/
            } catch (Exception e1) {
                System.out.println("Background image loading error!");
            }

            try {
                mImageView.setImageResource(methodId);
            } catch (Exception e2) {
                System.out.println("Method's image loading error!");
            }

            try {
                methodTextName.setText((listOfRecipes.get(position)).getName());
            } catch (NullPointerException e3) {
                System.out.println("Method's name loading error!");
            }

            try {
                methodTextCoffeeAmount.setText((listOfRecipes.get(position)).getAmountOfCoffee());
            } catch (NullPointerException e4) {
                System.out.println("Method's amount of coffee loading error!");
            }

            try {
                methodTextWaterAmount.setText((listOfRecipes.get(position)).getAmountOfWater());
            } catch (NullPointerException e5) {
                System.out.println("Method's amount of water loading error!");
            }

            try {
                methodTextTimeAmount.setText((listOfRecipes.get(position)).getAmountOfTime());
            } catch (NullPointerException e6) {
                System.out.println("Method's amount of time loading error!");
            }

            try {
                methodTextTemperature.setText((listOfRecipes.get(position)).getTemperature());
            } catch (NullPointerException e6) {
                System.out.println("Method's temperature loading error!");
            }

            return view;
        }
    }

}