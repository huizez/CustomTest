package com.example.customdialog;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomButton extends androidx.appcompat.widget.AppCompatButton {

    public CustomButton(@NonNull Context context) {
        super(context);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
      /*  if (hasFocus()) {
            setBackground(getResources().getDrawable(R.drawable.has_focus_btn_bg));
            setTextColor(0xffffffff);
        } else {
            setBackgroundColor(getResources().getColor(R.color.lose_focus_btn_bg));
            setAlpha(0.20f);
            setTextColor(0x88ffffff);
        }*/
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            setBackground(getResources().getDrawable(R.drawable.has_focus_btn_bg));
//            setAlpha(1.0f);
            setTextColor(getResources().getColor(R.color.get_focus_font_color));
        } else {
            setBackground(getResources().getDrawable(R.drawable.lose_focus_btn_bg));
//            setAlpha(0.20f);
            setTextColor(getResources().getColor(R.color.lose_focus_font_color));
        }
    }

}
