package com.example.simpleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button seeAll,myFav,already,wishlisht,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AlbookingActivities.class);
                startActivity(intent);
            }
        });
        myFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyFavActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initialView() {
        seeAll = findViewById(R.id.seeAll);
        myFav = findViewById(R.id.currentBook);
        already = findViewById(R.id. already);
        wishlisht = findViewById(R.id.wishlisht);
        about = findViewById(R.id.about);

    }
}