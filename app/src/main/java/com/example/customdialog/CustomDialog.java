package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDialog extends Dialog {
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
    }
}
