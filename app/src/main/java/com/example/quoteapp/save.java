package com.example.quoteapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class save extends AppCompatActivity {

    private ArrayList<quote> qList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);


        Log.d("Reading: ", "Reading all quotes..");
        DatabaseHandler db = new DatabaseHandler(this);
        qList = db.getAllqotes();

        ListView listView = findViewById(R.id.list_view);
        MyListAdapter listAdapter = new MyListAdapter(this, qList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                quote stdInfo = listAdapter.getItem(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(save.this);

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        db.deletequote(stdInfo);
                        Toast.makeText(save.this, "Quote deleted successfully..", Toast.LENGTH_SHORT).show();

                        qList.clear();
                        qList.addAll(db.getAllqotes());
                        listAdapter.notifyDataSetChanged();
                    }
                });
                //Creating dialog box
                AlertDialog alert = builder.create();
                alert.setTitle("User Action");
                alert.show();
            }
        });

        Button delbtn=findViewById(R.id.btndelall);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteall( );
                Toast.makeText(save.this, "quotes deleted successfully..", Toast.LENGTH_SHORT).show();
                qList.clear();
                qList.addAll(db.getAllqotes());
                listAdapter.notifyDataSetChanged();
            }
        });

        Button backk=findViewById(R.id.btnback);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(save.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}
