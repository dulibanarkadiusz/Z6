package com.example.arek.zadanie6;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExpandableActivity extends AppCompatActivity {
    ExpandableActivity mThis = this;
    ArrayList<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        Resources res = getResources();
        String[] strings = res.getStringArray(R.array.myNames);
        TypedArray typedArray = res.obtainTypedArray(R.array.myArray);
        String[] catetogries = res.getStringArray(R.array.categoryReferences);

        entries = new ArrayList<>();
        for (int i=0; i<strings.length; i++) {
            entries.add(new Entry(strings[i], typedArray.getResourceId(i, 0), catetogries));
        }

        //EntryAdapter entryAdapter = new EntryAdapter(this, R.layout.list_item, entries);
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, R.layout.list_item, entries);

        ExpandableListView gridView = (ExpandableListView)findViewById(R.id.expandableListView);
        gridView.setAdapter(expandableAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mThis, i+" - "+entries.get(i).Name, Toast.LENGTH_LONG).show();
            }
        });
    }
}
