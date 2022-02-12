package com.example.simpleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
  private TextView bookid, name;
  private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
   initData();
   //获得点击的书
        Intent intent = getIntent();
        if (null!= intent){
            //因为没有id是-1 所以随便设一个，这个方法不设是不行的
            int bookid= intent.getIntExtra("bookid",-1);
            if (bookid!=-1){
                //获得点击的书的id
                Book incomingBook = utils.getInstance().getBookByid(bookid);
                if (incomingBook!=null){
                    setData(incomingBook);
                    handleAlreadyAddToFav(incomingBook);
                }
            }
        }

    }

    private void handleAlreadyAddToFav(Book incomingBook) {
        ArrayList<Book> FavBook = utils.getInstance().getFavourite();
        boolean existedFav=false;
        //检查favbooking中是否有正在选择的这个
        for (Book b: FavBook){
            if (b.getId()==incomingBook.getId()){
                existedFav=true;
            }
        }
          // 如果存在就直接让按钮不能使用
        if (existedFav==true){
            button.setEnabled(false);
        }else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (utils.getInstance().AddBooktofavourite(incomingBook)){
                        Toast.makeText(BookActivity.this, "Book add", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( BookActivity.this,MyFavActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(BookActivity.this, "Somthing Wrong happened", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void initData() {
        bookid =findViewById(R.id.bookid);
        name=findViewById(R.id.name);
        button=findViewById(R.id.addToMyfavourite);
    }

    private void setData(Book book){
        bookid.setText(book.getAuthor());
        name.setText(book.getName());
    }
}