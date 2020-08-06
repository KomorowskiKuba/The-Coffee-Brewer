package com.example.thecoffeebrewer;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {
    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
    private int ID;
    private String method;
    private String name;
    private String amountOfWater;
    private String amountOfTime;
    private String amountOfCoffee;
    private String temperature;
    private String grindSize;
    private String tableOfGraphics;
    private String tableOfInstructions;
    private String tableOfTime;
    private String isfavourite;

    Recipe(String method, String name) {
        this.method = method;
        this.name = name;
    }

    Recipe(String id, String method, String name, String amountOfWater, String amountOfTime, String amountOfCoffee, String temperature, String grindSize, String tableOfGraphics, String tableOfInstructions, String tableOfTime, String isFavourite) {
        this.ID = Integer.parseInt(id);
        this.method = method;
        this.name = name;
        this.amountOfWater = amountOfWater;
        this.amountOfTime = amountOfTime;
        this.amountOfCoffee = amountOfCoffee;
        this.temperature = temperature;
        this.grindSize = grindSize;
        this.tableOfGraphics = tableOfGraphics;
        this.tableOfInstructions = tableOfInstructions;
        this.tableOfTime = tableOfTime;
        this.isfavourite = isFavourite;
    }

    protected Recipe(Parcel in) {
        ID = in.readInt();
        method = in.readString();
        name = in.readString();
        amountOfWater = in.readString();
        amountOfTime = in.readString();
        amountOfCoffee = in.readString();
        temperature = in.readString();
        grindSize = in.readString();
        tableOfGraphics = in.readString();
        tableOfInstructions = in.readString();
        tableOfTime = in.readString();
        isfavourite = in.readString();
    }

    public int getID() {
        return ID;
    }

    public String getMethod() {
        return method;
    }

    public String getName() {
        return name;
    }

    public String getAmountOfWater() {
        return amountOfWater;
    }

    public String getAmountOfTime() {
        return amountOfTime;
    }

    public String getAmountOfCoffee() {
        return amountOfCoffee;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getGrindSize() {
        return grindSize;
    }

    public String getTableOfGraphics() {
        return tableOfGraphics;
    }

    public String getTableOfInstructions() {
        return tableOfInstructions;
    }

    public String getTableOfTime() {
        return tableOfTime;
    }

    public String getIsfavourite() {
        return isfavourite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(method);
        dest.writeString(name);
        dest.writeString(amountOfWater);
        dest.writeString(amountOfTime);
        dest.writeString(amountOfCoffee);
        dest.writeString(temperature);
        dest.writeString(grindSize);
        dest.writeString(tableOfGraphics);
        dest.writeString(tableOfInstructions);
        dest.writeString(tableOfTime);
        dest.writeString(isfavourite);
    }
}
