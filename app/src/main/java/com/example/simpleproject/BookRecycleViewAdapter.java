package com.example.simpleproject;

import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecycleViewAdapter extends RecyclerView.Adapter<BookRecycleViewAdapter.ViewHolder> {
    private static final String TAG = "BookRecycleViewAdapter";
  private ArrayList<Book> books = new ArrayList<>();
  private Context myContext;
  //判断是哪个activity
  private String avtivity;

    public BookRecycleViewAdapter(Context myContext, String avtivity) {
        this.myContext = myContext;
        this.avtivity = avtivity;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged(); // refresh data in our recycleview
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        ViewHolder viewHolder = (ViewHolder)holder;
       viewHolder.textView.setText(books.get(position).getName());
        Glide.with(myContext).asBitmap().load(books.get(position).getImageUrl()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // intent 同样可以传递数据
                Intent intent = new Intent(myContext,BookActivity.class);
                intent.putExtra("bookid",books.get(position).getId());
                myContext.startActivity(intent);
            }
        });

        //更改用户名和描述
        holder.author.setText(books.get(position).getAuthor());
        holder.textAuthor.setText(books.get(position).getAuthor());
        holder.txtDes.setText(books.get(position).getShortDesc());

        if(books.get(position).isExpanded()){
            //过度效果
            TransitionManager.beginDelayedTransition(holder.cardView);
            holder.descrption.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);

            if (avtivity.equals("allBookActivity")){
                //all book page 不显示
                   holder.textDel.setVisibility(View.GONE);
            }else if (avtivity.equals("myfavActivity")){
                //删除
                holder.textDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (  utils.getInstance().delFavBook(books.get(position))){
                            Toast.makeText(myContext, "delete success", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }else {
                            Toast.makeText(myContext, "System Wrong,pls try again later", Toast.LENGTH_SHORT).show();
                        }
                      
                    }
                });
            }
        }else {
            TransitionManager.beginDelayedTransition(holder.cardView);
            holder.descrption.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return books.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private ImageView imageView;
        private TextView textView;
        private ImageView downArrow, upArrow;
        private RelativeLayout descrption;
        private TextView author,textAuthor,txtDes, textDel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView= itemView.findViewById(R.id.parent);
            imageView= itemView.findViewById(R.id.imgbook);
            textView= itemView.findViewById(R.id.text);

            downArrow= itemView.findViewById(R.id.down_arror);
            upArrow=itemView.findViewById(R.id.btn_up_arro);
            descrption=itemView.findViewById(R.id.description);
            author=itemView.findViewById(R.id.author);
            textAuthor=itemView.findViewById(R.id.txtAuthor);
            txtDes=itemView.findViewById(R.id.des);
            textDel=itemView.findViewById(R.id.deletebtn);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //getgetAdapterPosition() 可以得到当前创建的viewholder的position
                  Book book = books.get(getAdapterPosition());
                  book.setExpanded(!book.isExpanded());
                  notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }

//ViewHolder

}
