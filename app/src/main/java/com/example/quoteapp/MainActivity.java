package com.example.quoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r=new Random();
    ImageView btnrefresh,sharee,savee;
    TextView tvqote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvqote=findViewById(R.id.tvquote);
        btnrefresh=findViewById(R.id.refbtn);
        sharee=findViewById(R.id.share);
        CardView cd=findViewById(R.id.c_quote);
        btnrefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                quotes();
            }
        });
        quotes();
        sharee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String storeq= tvqote.getText().toString().trim();
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plane");
                i.putExtra(Intent.EXTRA_TEXT,storeq);
                startActivity(i);

            }
        });

        savee = findViewById(R.id.save);
        savee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String q = tvqote.getText().toString().trim();


                Log.d("saving: ", "saving ..");
                DatabaseHandler db = new DatabaseHandler(MainActivity.this);
                db.addqote(new quote(q));
                Toast.makeText(MainActivity.this, "quote Saved successfully..", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, save.class));
                finish();
            }
        });

        Button btnsavedqts=findViewById(R.id.btnsaved);
        btnsavedqts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,save.class);
                startActivity(i);
            }
        });
    }




    public void quotes()
    {
        int random=r.nextInt((15+1)-1)+1;
        String rq= "";
        switch (random)
        {
            case 1:
                rq=getString(R.string.q1);
                break;
            case 2:
                rq=getString(R.string.q2);
                break;
            case 3:
                rq=getString(R.string.q3);
                break;
            case 4:
                rq=getString(R.string.q4);
                break;
            case 5:
                rq=getString(R.string.q5);
                break;
            case 6:
                rq=getString(R.string.q6);
                break;
            case 7:
                rq=getString(R.string.q7);
                break;
            case 8:
                rq=getString(R.string.q8);
                break;
            case 9:
                rq=getString(R.string.q9);
                break;
            case 10:
                rq=getString(R.string.q10);
                break;
            case 11:
                rq=getString(R.string.q11);
                break;
            case 12:
                rq=getString(R.string.q12);
                break;
            case 13:
                rq=getString(R.string.q13);
                break;
            case 14:
                rq=getString(R.string.q14);
                break;
            case 15:
                rq=getString(R.string.q15);
                break;
        }
        tvqote.setText(rq);
    }
}