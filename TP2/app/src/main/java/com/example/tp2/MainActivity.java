package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FactBook mFactBook = new FactBook();
        ColorWheel mColorWheel = new ColorWheel();

        final TextView factLabel = (TextView) findViewById(R.id.textView2);
        final Button showFactButton = (Button) findViewById(R.id.button);
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        showFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fact = mFactBook.getFact();
                factLabel.setText(fact);

                int color = mColorWheel.getColor();
                constraintLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        });
    }

}
