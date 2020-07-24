package com.example.thecoffeebrewer;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListOfMethodsActivity extends AppCompatActivity {

    ListView mListView;
    int imgSource = R.drawable.aeropressicon;
    String [] names = {"Slovak AeroPress Championship 2016 - 1st", "Przepis 2", "Przepis 3", "Przepis 4", "Przepis 5", "Przepis 6", "Przepis 7", "Przepis 8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_methods);

        mListView = (ListView) findViewById(R.id.ListView);

        CustomAdapter customAdapter = new CustomAdapter();
        mListView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
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

            ImageView mImageView = (ImageView) view.findViewById(R.id.MethodImageView);
            TextView mTextView = (TextView) view.findViewById(R.id.MethodTextView);

            try {
                mImageView.setImageResource(imgSource);
            } catch (Exception e) {
                System.out.println("BLAD USTAWIANIA OBRAZU");
            }
            try {
                mTextView.setText(names[position]);
            } catch (NullPointerException ne) {
                System.out.println("BLAD USTAWIANIA TEKSTU");
            }

            return view;
        }
    }

    /*private void createRecipe(Context context, LinearLayout linearLayout, String name) {
        ImageButton imageButton = new ImageButton(context);
        imageButton.setImageResource(R.drawable.roundedrectangle);
        linearLayout.addView(imageButton);
        TextView textView = new TextView(context);
        textView.setText(name);
        linearLayout.addView(textView);

    }*/
}