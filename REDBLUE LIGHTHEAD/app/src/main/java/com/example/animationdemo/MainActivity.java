package com.example.animationdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button button;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        button = findViewById(R.id.button);

        layout.setBackgroundColor(Color.RED);
        button.setOnClickListener(v -> {
            int color = ((ColorDrawable) layout.getBackground()).getColor();
            if (color == Color.RED) {
                layout.setBackgroundColor(Color.BLUE);
                button.setText("Change Blue!");
            } else {
                layout.setBackgroundColor(Color.RED);
                button.setText("Change Red!");
            }
        });
    }
}