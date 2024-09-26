package com.example.mobileweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightCm;
    EditText weightKg;
    Button calculateButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightCm = findViewById(R.id.heightCm);
        weightKg = findViewById(R.id.weightKg);
        calculateButton = findViewById(R.id.calculateButton);
        resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightCm.setText("");
                weightKg.setText("");
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double heightInMeters;
                double heightSquared;

                // Get height input
                String heightInCmString = heightCm.getText().toString();
                if (heightInCmString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your height.", Toast.LENGTH_SHORT).show();
                    return; // Exit if height input is empty
                }

                double heightInCm = Double.parseDouble(heightInCmString);

                // Validate height
                if (heightInCm >= 80 && heightInCm <= 300) {
                    heightInMeters = heightInCm / 100;
                    heightSquared = heightInMeters * heightInMeters;
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a height between 80 cm and 300 cm.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get weight input
                String weightKgString = weightKg.getText().toString();
                if (weightKgString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your weight.", Toast.LENGTH_SHORT).show();
                    return; // Exit if weight input is empty
                }

                double weightKgInt = Double.parseDouble(weightKgString);

                // Validate weight
                if (weightKgInt >= 20 && weightKgInt <= 200) {
                    double bmi = weightKgInt / heightSquared;

                    // Start the second activity and pass the BMI value
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("BMI", bmi);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a weight between 20 kg and 200 kg.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
