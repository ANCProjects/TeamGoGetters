package com.musicapp.android.allure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find View that shows number category.
        TextView hiphop = (TextView)findViewById(R.id.hiphop);

        // Set a ClickListener on that View
        hiphop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent i = new Intent(MainActivity.this, HipHopActivity.class);
                // Start the new activity
                startActivity(i);

            }
        });

        // Find View that shows Family Members category.
        TextView rythm = (TextView)findViewById(R.id.rnb);

        // Set a ClickListener on that View
        rythm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent i = new Intent(MainActivity.this, RnBActivity.class);
                // Start the new activity
                startActivity(i);

            }
        });

        // Find View that shows number category.
        TextView rap = (TextView)findViewById(R.id.rap);

        // Set a ClickListener on that View
        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent i = new Intent(MainActivity.this, RapActivity.class);
                // Start the new activity
                startActivity(i);

            }
        });

        // Find View that shows number category.
        TextView rock = (TextView)findViewById(R.id.rock);

        // Set a ClickListener on that View
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent i = new Intent(MainActivity.this, RockActivity.class);
                // Start the new activity
                startActivity(i);

            }
        });
    }
}
