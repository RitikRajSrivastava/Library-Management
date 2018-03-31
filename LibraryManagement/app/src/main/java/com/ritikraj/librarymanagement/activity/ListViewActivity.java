package com.ritikraj.librarymanagement.activity;

/**
 * Created by Ritik Raj Srivastava on 09-10-2017.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ritikraj.librarymanagement.R;

public class ListViewActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // storing string resources into Array
        String[] years = getResources().getStringArray(R.array.years);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_year, R.id.label, years));

        ListView lv = getListView();

        // listening to single list item on click
        //Toast.makeText(ListViewActivity.this,"Hello there 1",Toast.LENGTH_LONG).show();


        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                // selected item

               // Toast.makeText(ListViewActivity.this,"Hello there 2",Toast.LENGTH_LONG).show();


                String item = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(ListViewActivity.this, SendMail.class);
                // sending data to new activity
                 Toast.makeText(ListViewActivity.this,"Hello there",Toast.LENGTH_LONG).show();
             //   i.putExtra("product", item);
                startActivity(i);
                  finish();
            }
        });
    }
}