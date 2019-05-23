package com.example.manueleagzample.splashscreen.adapters;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.activities.EbookPreview;
import com.example.manueleagzample.splashscreen.activities.Ebooks;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;
import com.example.manueleagzample.splashscreen.utils.Downloader;

import java.util.ArrayList;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.ViewHolder> {

    private ArrayList<LibraryBooks> ebooks;
    private Context context;
    private Activity activity;

    public EbookAdapter(ArrayList<LibraryBooks> ebooks, Context context, Activity activity) {
        this.ebooks = ebooks;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.e_book_item, viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final LibraryBooks book = ebooks.get(i);
        viewHolder.publishingDate.setText(book.getAuthor());
        viewHolder.bookName.setText(book.getTitle());
        viewHolder.previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EbookPreview.class);
                intent.putExtra("E_BOOK_ID", book.getBookid());
                context.startActivity(intent);
            }
        });
        viewHolder.downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ebooks.pdfURL = book.getPdfURL();
                Ebooks.book = book;

                Downloader.download(book, context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ebooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton previewButton;
        private ImageButton downloadButton;
        private TextView bookName;
        private TextView publishingDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            previewButton = itemView.findViewById(R.id.preview_button);
            bookName = itemView.findViewById(R.id.book_name_text);
            publishingDate = itemView.findViewById(R.id.publishing_date);
            downloadButton = itemView.findViewById(R.id.download_button);
        }
    }
}
