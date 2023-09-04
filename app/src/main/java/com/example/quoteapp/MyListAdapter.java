package com.example.quoteapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<quote> {

    private final Activity context;
    private final List<quote> mList;

    public MyListAdapter(Activity context, List<quote> list) {
        super(context, R.layout.list_item, list);
        this.context=context;
        mList = list;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null,true);//

        TextView quoteoutput = (TextView) rowView.findViewById(R.id.qlines);


        quote info = mList.get(position);

        quoteoutput.setText(info.getquote());


        return rowView;
    }
}

