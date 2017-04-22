package com.hubu.mailbox.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hubu.mailbox.R;
import com.hubu.mailbox.adapter.AccountAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddAccountActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AccountAdapter adapter;

    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_account);

        initList();
        initView();
    }

    private void initList() {
        list = new ArrayList();
        for (int i=0; i<3; i++){
            list.add("1224269321@qq.com");
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.account_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new AccountAdapter(list);
        mRecyclerView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_btn:
                list.add("2645460762@qq.com");
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }

    }
}
