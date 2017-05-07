package com.example.arek.zadanie6;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class SimpleListActivity extends AppCompatActivity {
    ListView listView;
    SimpleListActivity thisObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        thisObj = this;

        Resources res = getResources();
        String[] strings = res.getStringArray(R.array.myNames);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                strings
        );
        listView = (ListView)findViewById(R.id.myBasicListView);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(thisObj, i+"", Toast.LENGTH_LONG);
            }
        });
    }
}
