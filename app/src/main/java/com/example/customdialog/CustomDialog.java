package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private CustomButton mPositiveBtn;
    private CustomButton mNegtiveBtn;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.custom_dialog);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mPositiveBtn = findViewById(R.id.allow);
        mNegtiveBtn = findViewById(R.id.disallow);
        mPositiveBtn.setOnClickListener(this);
        mNegtiveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allow:
                break;
            case R.id.disallow:
                break;
        }
    }
}
