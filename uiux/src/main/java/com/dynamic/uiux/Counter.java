package com.dynamic.uiux;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class Counter extends LinearLayout {
    public Counter(Context context) {
        super(context);
        init(context,null);
    }

    public Counter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public Counter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context ctx, AttributeSet attr){
        inflate(ctx,R.layout.counter,this);

    }
}
