package com.example.thecoffeebrewer;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Utils {

    Utils() {
    }

    public void setGoToListener(ImageButton imageButton, Context actualContext, Class c) {
        imageButton.setOnClickListener(e -> {
            try {
                Intent intent = new Intent(actualContext, c);
                actualContext.startActivity(intent);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void setGoToListener(ImageView imageView, Context actualContext, Class c) {
        imageView.setOnClickListener(e -> {
            try {
                Intent intent = new Intent(actualContext, c);
                actualContext.startActivity(intent);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void setTransferNameListener(ImageButton imageButton, Context actualContext, Class c, String data) {
        imageButton.setOnClickListener(e -> {
            try {
                Intent intent = new Intent(actualContext, c);
                intent.putExtra("methodName", data);
                actualContext.startActivity(intent);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void setTransferRecipeListener(ImageView ImageView, Context actualContext, Class c, Recipe r) {
        ImageView.setOnClickListener(e -> {
            try {
                Intent intent = new Intent(actualContext, c);
                intent.putExtra("Recipe", r);
                actualContext.startActivity(intent);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public int extractGrams(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }

        return Integer.parseInt(String.valueOf(stringBuilder));
    }


}
