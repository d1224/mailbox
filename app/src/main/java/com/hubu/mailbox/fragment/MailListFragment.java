package com.hubu.mailbox.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hubu.mailbox.R;
import com.hubu.mailbox.adapter.MailListAdapter;
import com.hubu.mailbox.bean.MailBean;

import java.util.ArrayList;
import java.util.List;

public class MailListFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private RecyclerView mRecyclerView;
    private List<MailBean> mData;
    private MailListAdapter adapter;

    private SwipeRefreshLayout swipeRefresh;

    public static MailListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        MailListFragment fragment = new MailListFragment();
        // 传递参数
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取参数
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mail_list, container, false);

        swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.swip_refresh);
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("------>", "RefreshListener");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefresh.setRefreshing(false);
                                Log.d("------>", "Successful");
                            }
                        });
                    }
                }).start();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView = (RecyclerView) view.findViewById(R.id.mail_list);
        mRecyclerView.setLayoutManager(layoutManager);

        mData = new ArrayList<>() ;

        for (int i=0; i<20; i++){
            MailBean bean = new MailBean();
            bean.setChatName("腾讯新闻" + i);
            bean.setChatContent("中国LOL首次获得世界联赛冠军" + i);
            bean.setChatDate("12:00");
            bean.setTips("10");
            mData.add(bean);
        }

        adapter = new MailListAdapter(mData);

        mRecyclerView.setAdapter(adapter);

        return view;
    }
}
