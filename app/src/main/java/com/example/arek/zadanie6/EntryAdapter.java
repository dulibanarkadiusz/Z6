package com.example.arek.zadanie6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arek on 2017-04-12.
 */

public class EntryAdapter extends ArrayAdapter<Entry> {
    final private LayoutInflater mInflater;
    final private int mLayoutId;

    public EntryAdapter(Context context, int resource, List<Entry> objects) {
        super(context, resource, objects);
        mLayoutId = resource;
        mInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = mInflater.inflate(mLayoutId, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Entry entry = getItem(position);
        textView.setText(entry.Name);
        imageView.setImageResource(entry.Logo);
        return convertView;
    }
}

