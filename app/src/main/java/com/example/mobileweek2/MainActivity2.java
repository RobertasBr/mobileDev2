package com.example.mobileweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = findViewById(R.id.arrowImageView);
        imageView.setImageResource(R.drawable.arrow);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("BMI", 0.0);

        TextView resultsText = findViewById(R.id.resultsText);
        resultsText.setText("Your BMI is:" + String.format("%.2f", bmi));

        if (bmi < 18.5) {
            imageView.setTranslationX(-350);
        } else if (bmi >= 18.5 && bmi < 25){
            imageView.setTranslationX(-50);
        } else if (bmi >= 25 && bmi < 30) {
            imageView.setTranslationX(300);
        } else {
            imageView.setTranslationX(450);
        }

        Button backButton;
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}