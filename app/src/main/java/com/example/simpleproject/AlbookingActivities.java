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

        adapter = new BookRecycleViewAdapter(this);
        recyclerView =findViewById(R.id.bookRecycle);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"1Q84","Murakami",1350,"https://th.bing.com/th/id/R.bf61cd5bd41e17b863e802f4b52aee7b?rik=IBsEzwb5huqeyQ&riu=http%3a%2f%2fimg2.imagesbn.com%2fp%2f9780307476463_p0_v1_s260x420.JPG&ehk=pt3gCwCIGISShaFJMDT5NyQxA%2b8bRhFm4hRksfhfhi0%3d&risl=&pid=ImgRaw&r=0","A work","Long decription"));
        adapter.setBooks(books);

    }
}