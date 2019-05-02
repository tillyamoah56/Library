package com.example.manueleagzample.splashscreen.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.activities.BookDetails;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>{
    public BooksAdapter(ArrayList<LibraryBooks> books, Context context) {
        this.books = books;
        this.context = context;
    }

    private ArrayList<LibraryBooks> books;
    private Context context;

    public static Filter getFilter() {
        return null;
    }
//    this is where the filter for the search of books based on the author,title and category



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View ItemView=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.library_layout, viewGroup, false);
        return new ViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final LibraryBooks book = books.get(i);
        viewHolder.title.setText(book.getTitle());
        viewHolder.author.setText(book.getAuthor());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, BookDetails.class);
                intent.putExtra("BOOK_ID", book.getBookid());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView author;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author =(TextView)itemView.findViewById(R.id.author_text);
            title =(TextView)itemView.findViewById(R.id.text_title);
            cardView=(CardView)itemView.findViewById(R.id.cardView);
        }
    }
}


