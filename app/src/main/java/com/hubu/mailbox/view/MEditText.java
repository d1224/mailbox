package com.hubu.mailbox.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hubu.mailbox.R;

public class MEditText extends LinearLayout {
    private EditText mEditText;
    private ImageView mImageView;

    public MEditText(Context context) {
        this(context, null);
    }

    public MEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context mContext) {
        LayoutInflater.from(mContext).inflate(R.layout.view_m_edittext, this, true);
        mEditText = (EditText) findViewById(R.id.editText);
        mImageView = (ImageView) findViewById(R.id.delete);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mEditText.getText().length() == 0){
                    mImageView.setVisibility(GONE);
                }else if (mEditText.getText().length() == 1){
                    mImageView.setVisibility(VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void setHint(String hint){
        mEditText.setHint(hint);
    }

    public String getText(){
        return mEditText.getText().toString();
    }
 }
