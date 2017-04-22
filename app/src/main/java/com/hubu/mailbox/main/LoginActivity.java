package com.hubu.mailbox.main;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hubu.mailbox.R;
import com.hubu.mailbox.utils.EmailUtil;
import com.hubu.mailbox.view.MEditText;

public class LoginActivity extends AppCompatActivity  {

    private MEditText phone;
    private EditText code;
    private TextView getCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        initView();
    }

    private void initView() {
        phone = (MEditText)findViewById(R.id.phone);
        code = (EditText) findViewById(R.id.verify_code);
        getCode = (TextView) findViewById(R.id.get_code);

        phone.setHint("手机号码");
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.get_code:
                break;
            case R.id.register:
                break;
        }
    }
}
