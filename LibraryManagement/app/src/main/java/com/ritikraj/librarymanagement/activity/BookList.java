package com.ritikraj.librarymanagement.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ritikraj.librarymanagement.R;

import java.util.List;

/**
 * Created by Ritik Raj Srivastava on 09-10-2017.
 */

public class BookList extends ArrayAdapter<Books> {
    private Activity context;
    private List<Books> booksList ;

    public BookList(Activity context,List<Books> booksList){

        super(context, R.layout.activity_book,booksList);
        this.context=context;
        this.booksList=booksList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_book, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Books artist = booksList.get(position);
        textViewName.setText(artist.getName());
        textViewGenre.setText(artist.getQuantity());

        return listViewItem;
    }
}
