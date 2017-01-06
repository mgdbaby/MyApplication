package com.example.myapplication;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by vargo on 2017/1/5.
 */

public class MyTextWatcher implements TextWatcher {
    private TextInputLayout mTextInputLayout;
    private String errorInfo;

    public MyTextWatcher(TextInputLayout textInputLayout, String errorInfo) {
        this.mTextInputLayout = textInputLayout;
        this.errorInfo = errorInfo;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mTextInputLayout.getEditText().getText().toString().length() < 6) {
            mTextInputLayout.setErrorEnabled(true);//是否设置错误提示信息
            mTextInputLayout.setError(errorInfo);//设置错误提示信息
        }
    }
}
