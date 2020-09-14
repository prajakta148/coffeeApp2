package com.example.praju.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity {

    TextView cold,cadby,pricecold,pricecadby;
    EditText qtycold,qtycadby;
    Button ordercoffee,show;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        cold=(TextView)findViewById(R.id.tvcold);
        cadby=(TextView)findViewById(R.id.tvcadby);
        pricecold=(TextView)findViewById(R.id.tvpr1);
        pricecadby=(TextView)findViewById(R.id.tvpr2);
        ordercoffee=(Button)findViewById(R.id.btnorder);
        qtycold=(EditText)findViewById(R.id.etqty1);
        qtycadby=(EditText)findViewById(R.id.etqty2);
        show=(Button)findViewById(R.id.btnset);

        databaseReference= FirebaseDatabase.getInstance().getReference("coffee");


        ordercoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quant1,quant2;
                quant1=qtycold.getText().toString();
                quant2=qtycadby.getText().toString();
                int q1,q2,total1,total2;
                if(quant1.length()==0 ){
                    quant1="0";
                }
                    q1=Integer.parseInt(quant1);
                if(quant2.length()==0 ){
                    quant2="0";
                }
                q2=Integer.parseInt(quant2);

                total1=Integer.parseInt(pricecold.getText().toString())*q1;
                total2=Integer.parseInt(pricecadby.getText().toString())*q2;


                databaseReference.child(pricecold.getText().toString()).setValue(total1);
                databaseReference.child(pricecadby.getText().toString()).setValue(total2);


            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ShowData.class));
            }
        });

   }

}
