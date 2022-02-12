package com.example.simpleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AlbookingActivities extends AppCompatActivity {
  private RecyclerView recyclerView;
  private BookRecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albooking_activities);

        adapter = new BookRecycleViewAdapter(this,"allBookActivity");
        recyclerView =findViewById(R.id.bookRecycle);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks( utils.getInstance().getAllBooks());

    }
}