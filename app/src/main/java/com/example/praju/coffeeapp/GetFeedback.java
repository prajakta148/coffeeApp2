package com.example.praju.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class GetFeedback extends AppCompatActivity {

    TextView getfeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_feedback);

        getfeedback=findViewById(R.id.tvget);
        getfeedback.setMovementMethod(new ScrollingMovementMethod());

        getfeedback.setText(getIntent().getStringExtra("result"));
    }
}
