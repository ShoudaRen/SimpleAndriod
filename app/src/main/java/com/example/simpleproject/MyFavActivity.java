package com.example.simpleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MyFavActivity extends AppCompatActivity {
    private RecyclerView MyfaVrecyclerView;
    private BookRecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fav);


        adapter = new BookRecycleViewAdapter(this,"myfavActivity");
        MyfaVrecyclerView =findViewById(R.id.myFavbookRecycle);
        MyfaVrecyclerView.setAdapter(adapter);

        MyfaVrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks( utils.getInstance(this).getFavourite());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}