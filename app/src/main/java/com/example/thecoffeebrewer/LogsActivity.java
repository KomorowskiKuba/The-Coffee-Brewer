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

public class LogsActivity extends AppCompatActivity {

    private List<Recipe> listOfRecipes = new ArrayList<Recipe>();
    private ListView logsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor c = databaseHelper.getLogs();

        if (c.getCount() == 0) {
            System.out.println("Cursor's error!");
        } else {

            while (c.moveToNext()) {
                Recipe r = new Recipe(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6),
                        c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11));

                listOfRecipes.add(r);
            }
        }

        logsListView = findViewById(R.id.LogsListView);
        LogsActivity.CustomAdapter customAdapter = new LogsActivity.CustomAdapter();
        logsListView.setAdapter(customAdapter);
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

            if (position == 0) {
                view = getLayoutInflater().inflate(R.layout.top_list_layout, null);
                ImageView tImageView = view.findViewById(R.id.toplistImageView);
                TextView tTextView = view.findViewById(R.id.toplistTextView);

                try {
                    tImageView.setImageResource(R.drawable.logsicon);
                } catch (Exception e1) {
                    Log.e("ListOfMethodsActivity", "Top card's image view loading error!");
                }

                try {
                    tTextView.setText("Logs");
                } catch (Exception e2) {
                    Log.e("ListOfMethodsActivity", "Top card's text view loading error!");
                }
            } else {
                Global global = new Global();
                Integer imageID = global.getMethodId((listOfRecipes.get(position).getMethod()));

                ImageView background = view.findViewById(R.id.rectanglebackground);
                ImageView mImageView = view.findViewById(R.id.MethodImageView);
                TextView methodTextName = view.findViewById(R.id.MethodName);
                TextView methodTextCoffeeAmount = view.findViewById(R.id.CoffeeAmountText);
                TextView methodTextWaterAmount = view.findViewById(R.id.WaterAmountText);
                TextView methodTextTimeAmount = view.findViewById(R.id.TimeAmountText);
                TextView methodTextTemperature = view.findViewById(R.id.TemperatureText);

                try {
                    utils.setTransferRecipeListener(background, LogsActivity.this, MethodActivity.class, listOfRecipes.get(position));
                } catch (Exception e1) {
                    System.out.println("Background image loading error!");
                }

                try {
                    mImageView.setImageResource(imageID);
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
            }

            return view;
        }
    }
}