package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    private SearchView mSearchView=null;
    private ListView mListView=null;
    private String[] mData={"input1","input2","input3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView=(SearchView) findViewById(R.id.search_view);
        mListView=(ListView) findViewById((R.id.list_view));

        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mData));
        mListView.setTextFilterEnabled(true);


        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;}
            @Override
                public boolean onQueryTextChange(String newText) {
                    if (!TextUtils.isEmpty(newText)){
                        mListView.setTextFilterEnabled(true);
                        mListView.setFilterText(newText);

                    }else{
                        mListView.setTextFilterEnabled(true);
                        mListView.clearTextFilter();
                    }
                    return false;
                }
            });

    }
}