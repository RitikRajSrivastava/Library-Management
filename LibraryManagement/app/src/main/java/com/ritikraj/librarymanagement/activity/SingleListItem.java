package com.ritikraj.librarymanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ritikraj.librarymanagement.R;

/**
 * Created by Ritik Raj Srivastava on 09-10-2017.
 */

public class SingleListItem extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_itemview);

        TextView txtProduct = (TextView) findViewById(R.id.year);

        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        txtProduct.setText(product);

    }
}
