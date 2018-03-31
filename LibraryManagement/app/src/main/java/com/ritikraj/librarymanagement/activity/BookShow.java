package com.ritikraj.librarymanagement.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ritikraj.librarymanagement.R;

import java.util.List;

/**
 * Created by Ritik Raj Srivastava on 09-10-2017.
 */

public class BookShow extends AppCompatActivity {

    DatabaseReference databaseArtists;
    List<Books> artists;
    ListView listViewArtists;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemview);
        databaseArtists = FirebaseDatabase.getInstance().getReference("Books");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
             // artists.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Books artist = postSnapshot.getValue(Books.class);
                    //adding artist to the list
                    artists.add(artist);
                }

                //creating adapter
                BookList artistAdapter = new BookList(BookShow.this,artists);
                //attaching adapter to the listview
                listViewArtists.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }
    }
