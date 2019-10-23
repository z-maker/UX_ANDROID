package com.dynamic.uiux;

import android.content.Context;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;

public class RoundedButton extends android.support.v7.widget.AppCompatButton {
    public RoundedButton(Context context) {
        super(context);
        init(context,null);
    }

    public RoundedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RoundedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context ctx, AttributeSet attr){

        this.setBackground(AppCompatResources.getDrawable(ctx,R.drawable.corner_radius_bg));
    }




}
