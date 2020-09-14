package com.example.praju.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OurBranches extends AppCompatActivity {

    TextView cc,cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_branches);

        cc=(TextView)findViewById(R.id.tv2);
        cb=(TextView)findViewById(R.id.tv3);
    }

    public void onCrush(View view) {
        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("loc","Cafe Crush Sangli");
        startActivity(intent);

    }

    public void onBrosta(View view) {
        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("loc","Cafe Brosta Sangli");
        startActivity(intent);

    }
}
