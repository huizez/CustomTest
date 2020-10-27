package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private ImageView mAppIcon;
    private TextView mAppLabel;
    private TextView mAppVersion;
    private CustomButton mPositiveBtn;
    private CustomButton mNegtiveBtn;
    private ApkInfo mApkInfo;
    private String mPackageName;
    private Context mContext;

    public CustomDialog(@NonNull Context context, String packageName) {
        super(context);
        mContext = context;
        mPackageName = packageName;
        mApkInfo = getApkInfo(mPackageName);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable,
                           @Nullable OnCancelListener cancelListener) {
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

        mAppIcon = findViewById(R.id.app_icon);
        mAppLabel = findViewById(R.id.app_name);
        mAppVersion = findViewById(R.id.app_version);

        if (mAppIcon != null) {
            mAppIcon.setBackground(mApkInfo.getIcon());
            mAppLabel.setText(mApkInfo.getLabel());
            mAppVersion.setText(mApkInfo.getVersion());
        }
    }

    private ApkInfo getApkInfo(String packageName) {
        try {
            ApkInfo apkInfo = new ApkInfo();
            PackageInfo pkgInfo = mContext.getPackageManager().getPackageInfo(packageName, 0);
            apkInfo.setLabel(pkgInfo.applicationInfo.loadLabel(mContext.getPackageManager()).toString());
            apkInfo.setVersion(pkgInfo.versionName);
            apkInfo.setIcon(pkgInfo.applicationInfo.loadIcon(mContext.getPackageManager()));
            return apkInfo;
        } catch (Exception e) {

        }
        return null;
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
