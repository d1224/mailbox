package com.hubu.mailbox.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.hubu.mailbox.R;
import com.hubu.mailbox.view.SelectImageWindow;
import com.hubu.mailbox.view.SelectOperationWindow;

public class MailDetailActivity extends AppCompatActivity {

    private SelectOperationWindow mSelectOperationWindow;
    private WindowManager.LayoutParams params;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("毕业设计第一次尝试");

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

    private void initPopWindow() {
        mSelectOperationWindow = new SelectOperationWindow(this, null);
//        设置Popupwindow显示位置（从底部弹出）
        mSelectOperationWindow.showAtLocation(findViewById(R.id.layout_main), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        params = getWindow().getAttributes();
        //当弹出Popupwindow时，背景变半透明
        params.alpha=0.7f;
        getWindow().setAttributes(params);
        //设置Popupwindow关闭监听，当Popupwindow关闭，背景恢复1f
        mSelectOperationWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params = getWindow().getAttributes();
                params.alpha=1f;
                getWindow().setAttributes(params);
            }
        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.detail_btn:
                Toast.makeText(this, "详情", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_send:
                initPopWindow();
                break;
        }
    }
}
