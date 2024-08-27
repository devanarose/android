package com.example.customgridapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter extends BaseAdapter {

    private Context context;
    private String[] items;
    private String[] imageIds;

    public void customadapter(Context context, String[] items, String[] imageIds){
        this.context = context;
        this.imageIds = imageIds;
        this.items = items;
    }
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridViewItem;
        if(view == null){
            //inflate the grid item file
            LayoutInflater inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridViewItem = inflater.inflate(R.layout.griditem,viewGroup,false);
        }
        else {
            gridViewItem = view;
        }
        TextView textView = gridViewItem.findViewById(R.id.textView2);
        ImageView imageView = gridViewItem.findViewById(R.id.imageView2);

        textView.setText(items[i]);
        imageView.setImageResource(imageIds[i]);
        return gridViewItem;
    }
}
