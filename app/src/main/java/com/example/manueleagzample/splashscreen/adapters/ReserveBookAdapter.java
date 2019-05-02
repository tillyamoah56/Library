package com.example.manueleagzample.splashscreen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.models.ReservedBook;

import java.util.ArrayList;

public class ReserveBookAdapter extends RecyclerView.Adapter<ReserveBookAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ReservedBook> reservedBooks;

    public ReserveBookAdapter(Context context, ArrayList<ReservedBook> reservedBooks) {
        this.context = context;
        this.reservedBooks = reservedBooks;
    }

    @NonNull
    @Override
    public ReserveBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reserved_book_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReserveBookAdapter.ViewHolder viewHolder, int i) {
        final ReservedBook book = reservedBooks.get(i);
        viewHolder.reservationDate.setText(book.getReserveDate().toString());
        viewHolder.bookName.setText(book.getBook().getTitle());
    }

    @Override
    public int getItemCount() {
        return reservedBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bookName;
        private TextView reservationDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookName = itemView.findViewById(R.id.book_name_text);
            reservationDate = itemView.findViewById(R.id.reservation_date);
        }
    }
}
