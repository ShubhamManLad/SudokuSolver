package com.example.sudokosolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplaySolution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_solution);
        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String ans = intent.getStringExtra("Solution");

        textView.setText(ans);


    }
}