package com.dynamic.uiux;

import android.content.Context;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;

public class RoundedIconButton extends android.support.v7.widget.AppCompatImageButton {
    public RoundedIconButton(Context context) {
        super(context);
        init(context,null);
    }

    public RoundedIconButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RoundedIconButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context ctx, AttributeSet attr){

        this.setBackground(AppCompatResources.getDrawable(ctx,R.drawable.corner_radius_bg));
    }
}
