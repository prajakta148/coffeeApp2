package com.example.praju.coffeeapp;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpeechtoText extends AppCompatActivity {

    TextView tv;
    ImageButton img;
    private final int REQ_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speechto_text);

        tv=(TextView)findViewById(R.id.tvtext);
        img=(ImageButton)findViewById(R.id.imageView1);
    }

    public void onSpeak(View view)
    {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello...Speak Something");
        try {
            startActivityForResult(intent,REQ_CODE);
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Error....",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQ_CODE==requestCode)
        {
            if (resultCode==RESULT_OK && data!=null)
            {
                ArrayList<String> result= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                tv.setText(result.get(0));
            }
        }
    }
}
