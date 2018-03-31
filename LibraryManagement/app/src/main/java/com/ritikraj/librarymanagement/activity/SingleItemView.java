package com.ritikraj.librarymanagement.activity;

/**
 * Created by Ritik Raj Srivastava on 10-10-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ritikraj.librarymanagement.R;

public class SingleItemView extends Activity {

    // Declare Variables
    TextView txtrank;
    TextView txtcountry;
    TextView txtpopulation;
    String[] rank;
    String[] country;
    String[] population;
    int position;
  Button b4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from MainActivity on listview item click
        Intent i = getIntent();
        // Get the listview item click position
        position = i.getExtras().getInt("position");
        // Get the list of rank
        rank = i.getStringArrayExtra("rank");
        // Get the list of country
        country = i.getStringArrayExtra("country");
        // Get the list of population
        population = i.getStringArrayExtra("population");

        // Locate the TextViews in singleitemview.xml
        txtrank = (TextView) findViewById(R.id.rank);
        txtcountry = (TextView) findViewById(R.id.country);
        txtpopulation = (TextView) findViewById(R.id.population);

        // Load the text into the TextViews followed by the position
        txtrank.setText(rank[position]);
        txtcountry.setText(country[position]);
        txtpopulation.setText(population[position]);


        b4 = (Button)findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i = new Intent(SingleItemView.this,SendMail.class);
               i.putExtra("id",rank[position]);
                i.putExtra("name",country[position]);
                startActivity(i);
                Toast.makeText(SingleItemView.this,"Thanks For Selecting",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}