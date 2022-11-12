package com.example.tp2;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {

    public String[] mColors = {
            "#39add1",
            "#3079ab",
            "#c25975",
            "#e15258",
            "#f9845b",
            "#838cc7",
            "#7d669e",
            "#53bbb4",
            "#51b46d",
            "#e0ab18",
            "#637a91",
            "#f092b0",
            "#b7c0c7"
    };

    public int getColor(){

        String color = "";
        Random randomGenerator = new Random();
        int indexRandom = randomGenerator.nextInt(mColors.length);

        color = mColors[indexRandom];
        int colorAsInt = Color.parseColor(color);


        return colorAsInt;
    }

}
