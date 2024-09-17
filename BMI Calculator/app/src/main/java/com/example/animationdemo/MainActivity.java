package com.example.animationdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView BMICategory, BMIValue;
    Button calculateBMIButton;
    EditText weightET, heightET;

    String category;
    double weight, height;
    double BMICalculated;

    int categoryColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightET = findViewById(R.id.weight_edit_text);
        heightET = findViewById(R.id.height_edit_text);

        calculateBMIButton = findViewById(R.id.calculate_button);

        BMIValue = findViewById(R.id.BMI_value_textview);
        BMICategory = findViewById(R.id.BMI_category_textview);

        calculateBMIButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String extractedWeight = weightET.getText().toString();
        String extractedHeight = heightET.getText().toString();

        weight = Double.parseDouble(extractedWeight);
        height = Double.parseDouble(extractedHeight);

        BMICalculated = weight / (height * height);

        if (BMICalculated >= 0 && BMICalculated < 15) {
            category = "Very severely underweight";
            categoryColor = Color.BLUE;
        } else if (BMICalculated >= 15 && BMICalculated < 16) {
            category = "Severely underweight";
            categoryColor = Color.rgb(143, 217, 251);
        } else if (BMICalculated >= 16 && BMICalculated < 18.5) {
            category = "Underweight";
            categoryColor = Color.rgb(17,17,132);
        } else if (BMICalculated >= 18.5 && BMICalculated < 25) {
            category = "Normal";
            categoryColor = Color.GREEN;
        } else if (BMICalculated >= 25 && BMICalculated < 30) {
            category = "Overweight";
            categoryColor = Color.YELLOW;
        } else if (BMICalculated >= 30 && BMICalculated < 35) {
            category = "Obese Class 1 - Moderately Obese";
            categoryColor = Color.rgb(255, 165, 0);
        } else if (BMICalculated >= 35 && BMICalculated < 40) {
            category = "Obese Class 2 - Severely Obese";
            categoryColor = Color.rgb(229, 103, 23);
        } else {
            category = "Obese Class 3 - Very Severely Obese";
            categoryColor = Color.RED;
        }

        DecimalFormat df = new DecimalFormat("#.#");
        double BMI_trimmed = Double.parseDouble(df.format(BMICalculated));
        BMIValue.setText(String.valueOf(BMI_trimmed));

        BMICategory.setVisibility(View.VISIBLE);
        BMICategory.setTextColor(categoryColor);
        BMICategory.setText(category);
    }
}