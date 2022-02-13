package com.example.simpleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AlbookingActivities extends AppCompatActivity {
  private RecyclerView recyclerView;
  private BookRecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albooking_activities);

//       // 对当前页面使用
//        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BookRecycleViewAdapter(this,"allBookActivity");
        recyclerView =findViewById(R.id.bookRecycle);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks( utils.getInstance(this).getAllBooks());

    }

    /***
     * 自定义动画
     */

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
//    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //调用这个方法
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}