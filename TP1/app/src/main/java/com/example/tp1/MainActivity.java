package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText poids = findViewById(R.id.poids);
        EditText taille = findViewById(R.id.taille);
        poids.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                TextView res = findViewById(R.id.resultat);
                TextView vousDevez = (TextView) findViewById(R.id.textView4);
                vousDevez.setText("Vous devez cliquer sur le bouton CALCULER L'IMC pour obtenir un resultat");
                res.setText("Resultat: ");
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        taille.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) { }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView res = findViewById(R.id.resultat);
                TextView vousDevez =  findViewById(R.id.textView4);
                vousDevez.setText("Vous devez cliquer sur le bouton CALCULER L'IMC pour obtenir un resultat");
                res.setText("Resultat: ");
            }
        });
    }

    public void calculer(View view) {
        EditText poids = findViewById(R.id.poids);
        EditText taille = findViewById(R.id.taille);
        TextView res = findViewById(R.id.resultat);
        RadioGroup grp = findViewById(R.id.grp);
        CheckBox checkBox = findViewById(R.id.mega);
        int selectedRadioId = grp.getCheckedRadioButtonId();
        RadioButton selectedRadio = findViewById(selectedRadioId);
        String str = selectedRadio.getText().toString();
        double tailleInt = Double.parseDouble(taille.getText().toString());
        double finalTaille = str.equals("Metre") ? tailleInt : tailleInt / 100.00 ;
        try {
            double IMC = Double.parseDouble(poids.getText().toString()) / (finalTaille * finalTaille);
            if((int) finalTaille == 0) throw new ArithmeticException()  ;
            TextView finalres = findViewById(R.id.textView4);
            res.setText(String.valueOf(new DecimalFormat("##.##").format(IMC)));
            if(checkBox.isChecked()){
                if(IMC < 18.5) finalres.setText("Insuffisance pondérale (maigreur)");
                else if (IMC < 25){
                    finalres.setText("Corpulence normale");
                }
                else if (IMC < 30){
                    finalres.setText("Surpoids");
                }
                else if (IMC < 35){
                    finalres.setText("Obésité modérée");
                }
                else if (IMC < 40){
                    finalres.setText("Obésité sévère");
                } else {
                    finalres.setText("Obésité morbide ou massive");
                }
            }else {
                finalres.setText("Vous devez cliquer sur le bouton CALCULER L'IMC pour obtenir un resultat");
            }
        } catch (ArithmeticException ex){
            Toast.makeText(getApplicationContext(),"Cannot use 0 as taille",Toast.LENGTH_SHORT).show();
        }
    }

    public void annuler(View view) {
        EditText poids = findViewById(R.id.poids);
        EditText taille = findViewById(R.id.taille);
        poids.setText("");
        taille.setText("");

    }
}

