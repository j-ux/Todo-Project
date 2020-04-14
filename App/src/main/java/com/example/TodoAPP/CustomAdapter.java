package com.example.TodoAPP;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> descs = new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<String> tasks, ArrayList<String> descrition){
        this.items = tasks;
        this.descs = descrition;
        this.context = context;
        this.inflater = inflater.from(context);

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       view = inflater.from(context).inflate(R.layout.list_item_layout,null);

        TextView item = (TextView) view.findViewById(R.id.TVname);
        TextView description = (TextView) view.findViewById(R.id.TVdesc);

        item.setText(items.get(position));
        item.setTextColor(Color.GREEN);
        description.setText(descs.get(position));
        description.setTextColor(Color.BLUE);

        Log.e("########3",items.get(position));
        return view;
    }
}
