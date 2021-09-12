package com.example.covid_19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView=(ImageView)findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.heading);
        button=(Button)findViewById(R.id.track);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeScreen.this,MainActivity.class));


            }
        });
    }
}