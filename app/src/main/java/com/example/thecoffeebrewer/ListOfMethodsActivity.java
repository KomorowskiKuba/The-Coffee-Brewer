package com.example.thecoffeebrewer;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfMethodsActivity extends AppCompatActivity {

    ListView mListView;
    int imgSource = R.drawable.aeropressicon;
    String [] names = {"Slovak AeroPress Championship 2016 - 1st", "Przepis 2", "Przepis 3", "Przepis 4", "Przepis 5", "Przepis 6", "Przepis 7", "Przepis 8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_methods);

        mListView = findViewById(R.id.ListView);

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
            Utils utils = new Utils();

            ImageView background = view.findViewById(R.id.rectanglebackground);
            ImageView mImageView = view.findViewById(R.id.MethodImageView);
            TextView mTextView = view.findViewById(R.id.MethodTextView);

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
            try {
                utils.setGoToListener(background, ListOfMethodsActivity.this, MethodActivity.class);
            } catch (Exception e) {
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