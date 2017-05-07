package com.example.arek.zadanie6;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageGridActivity extends AppCompatActivity {
    ImageGridActivity mThis = this;
    ArrayList<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        Resources res = getResources();
        String[] strings = res.getStringArray(R.array.myNames);
        TypedArray typedArray = res.obtainTypedArray(R.array.myArray);

        entries = new ArrayList<>();
        for (int i=0; i<strings.length; i++) {
            entries.add(new Entry(strings[i], typedArray.getResourceId(i, 0)));
        }

        EntryAdapter entryAdapter = new EntryAdapter(this, R.layout.grid_item, entries);

        GridView gridView = (GridView)findViewById(R.id.imageGridView);
        gridView.setAdapter(entryAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mThis, i+" - "+entries.get(i).Name, Toast.LENGTH_LONG).show();
            }
        });
    }
}
