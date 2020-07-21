package com.example.thecoffeebrewer;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Method {

    Method(String name, String method, String rangeOfGrind, int amountOfCoffee, int amountOfWater, int temperature, int fullDurationInSeconds, List<Step> listOfSteps) {
    }

    public ImageButton createButton(Context c) {
        ImageButton imageButton = new ImageButton(c);
        int height = 300;
        imageButton.setMaxHeight(height);
        int width = 1000;
        imageButton.setMaxWidth(width);
        return imageButton;
    }

}
