package com.ritikraj.librarymanagement.activity;

/**
 * Created by Ritik Raj Srivastava on 10-10-2017.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;

import com.ritikraj.librarymanagement.R;

public class Main extends Activity {

        // Declare Variables
        ListView list;
        ListViewAdapter adapter;
        String[] rank;
        String[] country;
        String[] population;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Get the view from listview_main.xml
            setContentView(R.layout.listview_main);

            // Generate sample data into string arrays
            rank = new String[] { "jc1", "jc2", "jc3", "jc4", "jc5", "jc6", "jc7", "jc8", "jc9", "jc10" ,"jc11","jc12","jc13","jc14","jc15"};

            country = new String[] { "System Simulation", "System Software", "FAFL",
                    "Software Engineering", "DBMS", "ANSI C", "JAVA complete reference", "Circuit Theoery",
                    "Hello Android", "PSQ","Distributed Computing","SAN","Advanced Computer Architecture","Data Structure","Login Design" };

            population = new String[] { "10", "12",
                    "30", "26", "16", "10",
                    "10", "15", "16", "10","23","12","45","9","7" };

            // Locate the ListView in listview_main.xml
            list = (ListView) findViewById(R.id.listview);

            // Pass results to ListViewAdapter Class
            adapter = new ListViewAdapter(Main.this, rank, country, population);
            // Binds the Adapter to the ListView
            list.setAdapter(adapter);
            // Capture ListView item click
            list.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent i = new Intent(Main.this, SingleItemView.class);
                    // Pass all data rank
                    i.putExtra("rank", rank);
                    // Pass all data country
                    i.putExtra("country", country);
                    // Pass all data population
                    i.putExtra("population", population);
                    // Pass listview item click position
                    i.putExtra("position", position);
                    // Open SingleItemView.java Activity
                    startActivity(i);
                }

            });
        }
    }
