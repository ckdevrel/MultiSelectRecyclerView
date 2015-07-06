package com.takeoffandroid.multiselectrecyclergridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MultiSelectRecyclerViewActivity extends AppCompatActivity implements MultiSelectRecyclerViewAdapter.ViewHolder.ClickListener {

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private MultiSelectRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<String> mArrayList  = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_multiselect);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        for (int i = 1; i <= 50; i++) {

            mArrayList.add ("Item " + i);
        }

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("MultiSelectRecylcerView");

        }

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager (this,3));
        mAdapter = new MultiSelectRecyclerViewAdapter (MultiSelectRecyclerViewActivity.this,mArrayList,this);
        mRecyclerView.setAdapter (mAdapter);


    }

    @Override
    public void onItemClicked (int position) {

        toggleSelection(position);
    }

    @Override
    public boolean onItemLongClicked (int position) {
        toggleSelection(position);

        return true;
    }

    private void toggleSelection(int position) {
        mAdapter.toggleSelection (position);

    }
}