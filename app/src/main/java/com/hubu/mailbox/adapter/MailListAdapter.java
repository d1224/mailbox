package com.hubu.mailbox.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hubu.mailbox.R;
import com.hubu.mailbox.activity.MailDetailActivity;
import com.hubu.mailbox.bean.MailBean;

import java.util.List;

public class MailListAdapter extends RecyclerView.Adapter<MailListAdapter.ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout mRelativeLayout;
        ImageView headImg;
        TextView project;
        TextView title;
        TextView content;

        public ViewHolder(View view){
            super(view);

            mRelativeLayout = (RelativeLayout) view;
            headImg = (ImageView)view.findViewById(R.id.img);
            project = (TextView)view.findViewById(R.id.project);
            title = (TextView)view.findViewById(R.id.title);
            content = (TextView)view.findViewById(R.id.content);
        }
    }

    private List<MailBean> mData ;
    private Context mContext;

    public MailListAdapter(List<MailBean> mData){
        this.mData = mData ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mail_list, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(mContext, MailDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MailBean mail = mData.get(position);
        holder.project.setText(mail.getChatName());
        holder.title.setText(mail.getChatContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
