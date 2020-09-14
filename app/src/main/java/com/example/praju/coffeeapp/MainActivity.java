package com.example.praju.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView c1,c2,p1,p2,amount;
    Button order;
    EditText q1,q2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=findViewById(R.id.coffee1);
        c2=findViewById(R.id.coffee2);

        p1=findViewById(R.id.price1);
        p2=findViewById(R.id.price2);

        amount=findViewById(R.id.amount);

        order=findViewById(R.id.order);

        q1=findViewById(R.id.qty1);
        q2=findViewById(R.id.qty2);

    }
    public void order(View v)
    {
        int qt1,qt2 ,totalAmount=0,price1,price2;
        String tmp=q1.getText().toString();
        if(tmp.equals("")){
            qt1=0;
        }
        else
        {
            qt1=Integer.parseInt(tmp);
        }

        tmp=q2.getText().toString();
        if(tmp.length()==0){
            qt2=0;
        }
        else
        {
            qt2=Integer.parseInt(tmp);
        }

        price1=Integer.parseInt(p1.getText().toString());
        price2=Integer.parseInt(p2.getText().toString());
         totalAmount=price1*qt1 +price2*qt2;

         amount.setText("Total Amount:"+totalAmount);

    }
}

