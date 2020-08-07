package com.example.freegym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView , recycle;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageButton imgBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        //to display gym details
        imgBtn = findViewById(R.id.imageButton);
        recycle = findViewById(R.id.recyclerView);
        recycle.setVisibility(View.INVISIBLE);

        createExampleList();
        buildRecyclerView();

        final EditText editText = findViewById(R.id.etSearch);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
                if(editText.getText().toString().trim().length() > 0) {
                    imgBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recycle.setVisibility(View.VISIBLE);
                        }
                    });
                }
                else
                    recycle.setVisibility(View.INVISIBLE);

            }
        });

    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();
        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }
    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_location_on_24,"Madurai"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_location_on_24,"Trichy"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_location_on_24,"625001"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_location_on_24,"Salem"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_location_on_24,"Bangalore"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_location_on_24,"635001"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}