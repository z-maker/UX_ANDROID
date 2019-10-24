package com.dynamic.uiux;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Counter extends LinearLayout {

    private ImageButton btnAdd, btnDel;
    private TextView txtCount;
    private int count = 0;
    private boolean allowNegatives = false;

    private OnCountChangeListener listener;

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
        btnAdd = this.findViewById(R.id.btnAdd);
        txtCount = this.findViewById(R.id.txtCount);
        btnDel = this.findViewById(R.id.btnDel);


        TypedArray array = ctx.obtainStyledAttributes(attr,R.styleable.Counter);

        allowNegatives = array.getBoolean(R.styleable.Counter_allowNegatives,false);

        try {
            if (array.hasValue(R.styleable.Counter_min)) {
                String initCount = array.getString(R.styleable.Counter_min);
                assert initCount != null;
                count = Integer.parseInt(initCount);
            } else {
                count = Integer.parseInt(txtCount.getText().toString());
            }
        }catch (Exception ignored){}
        txtCount.setText(String.valueOf(count));

        array.recycle();

        setListeners();
    }

    private void setListeners(){

        btnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=1;
                txtCount.setText(String.valueOf(count));
                if (listener != null) listener.onCountChangeListener(count);
            }
        });

        btnDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!allowNegatives && count <= 0){
                    count = 0;
                }else {
                    count -= 1;
                }
                txtCount.setText(String.valueOf(count));

                if (listener != null) listener.onCountChangeListener(count);

            }
        });

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setListener(OnCountChangeListener listener) {
        this.listener = listener;
    }



    public interface OnCountChangeListener{
        void onCountChangeListener(int count);
    }

}
