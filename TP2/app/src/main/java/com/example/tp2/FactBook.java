package com.example.tp2;

import android.graphics.Color;

import java.util.Random;

public class FactBook {

    public String[] mFacts = {
            "Fourmis etendent quand ils se reveillent le matin.",
            "Autruches peuvent courir plus vite que les chevaux.",
            "Medailles d'or olympiques sont en fait surtout de l'argent.",
            "Vous etes ne avec 300 os, au moment ou vous etes un adulte, vous aurez 206.",
            "Il faut environ 8 minutes pour la lumiere du soleil pour atteindre la Terre.",
            "Certaines plantes de bambou peut pousser presque un metre en une seule journee.",
            "L'etat de Floride est plus grand que l'Angleterre.",
            "Certains pingouins peuvent sauter 2-3 metres hors de l'eau.",
            "En moyenne, it faut 66 jours pour former une nouvelle habitude.",
            "Mammouths marchait encore la terre, quand la Grande Pyramide a ete construct."
    };

    public String getFact(){

        String facts = "";
        Random randomGenerator = new Random();
        int indexRandom = randomGenerator.nextInt(mFacts.length);
        facts = mFacts[indexRandom];
        return facts;
    }
};
