package com.hubu.mailbox.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hubu.mailbox.R;
import com.hubu.mailbox.adapter.ImageAdapter;

public class TestActivity extends AppCompatActivity{

    private int[] list = {R.drawable.puzzle,R.drawable.puzzle,R.drawable.puzzle,R.drawable.puzzle,
            R.drawable.puzzle,R.drawable.puzzle,R.drawable.puzzle,R.drawable.puzzle};
    private ImageAdapter mImageAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_image);

        mRecyclerView = (RecyclerView)findViewById(R.id.rec_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mImageAdapter = new ImageAdapter(list);

        mRecyclerView.setAdapter(mImageAdapter);
    }
}
