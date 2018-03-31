package com.ritikraj.librarymanagement.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ritikraj.librarymanagement.R;

/**
 * Created by Ritik Raj Srivastava on 10-10-2017.
 */

public class SendMail extends AppCompatActivity {

    TextView t1,t2;
    TextView tv ;
    Button bt,bt3;
    String name;
    String id;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

      final String em = user.getEmail();

       // Toast.makeText(this,em,Toast.LENGTH_LONG).show();

 bt =(Button)findViewById(R.id.button2);
        bt3 =(Button)findViewById(R.id.button3);




       id = getIntent().getExtras().getString("id");
      name = getIntent().getExtras().getString("name");
        t1=(TextView)findViewById(R.id.textView2);
       t2=(TextView)findViewById(R.id.textView3);

        t1.setText(name);
        t2.setText(id);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendMail.this,SingleItemView.class));
                 finish();
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             //   SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(SendMail.this);
               // String userName = sharedPref.getString("userName", "Not Available");

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","LibraianSjce@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Request For Book");
                intent.putExtra(Intent.EXTRA_TEXT, "Book : "+name+"\nBook Id : "+id+"\n Tommorow @1:30...");
                startActivity(Intent.createChooser(intent,em));
                Toast.makeText(SendMail.this,"Message Going to Send..",Toast.LENGTH_LONG).show();
                   //startActivity();

            }
        });

    }
}
