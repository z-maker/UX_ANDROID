package com.dynamic.uiux;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.content.res.AppCompatResources;
import android.text.Editable;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dynamic.uiux.utils.DynamicPasswordTransormationMethod;


public class IconEditText extends LinearLayout {

    private EditText textInputLayout;
    private ImageView imageView;
    private Color focusedColor;

    public IconEditText(Context context) {
        super(context);
        init(context,null);
    }

    public IconEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public IconEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context c, AttributeSet a){
        inflate(c,R.layout.icon_edit_text,this);

        TypedArray array = c.obtainStyledAttributes(a,R.styleable.IconEditText);

        String placeholder = array.getString(R.styleable.IconEditText_placeholder);
        String text = array.getString(R.styleable.IconEditText_text);

        int icon = array.getResourceId(R.styleable.IconEditText_icon,R.drawable.ic_def);

        String text_type  = array.getString(R.styleable.IconEditText_tex_type);

        Drawable drawable = AppCompatResources.getDrawable(c,icon);

        @ColorInt int color  = array.getColor(R.styleable.IconEditText_focused_color,Color.BLACK);

        array.recycle();

        initComponens();

        textInputLayout.setHint(placeholder);
        textInputLayout.setText(text);

        assert text_type != null;
        switch (text_type){
            case "password":
                textInputLayout.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                textInputLayout.setTransformationMethod(new DynamicPasswordTransormationMethod());
                break;
            case "email":
                textInputLayout.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case "phone":
                textInputLayout.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            default:
                textInputLayout.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        }

        imageView.setImageDrawable(drawable);

    }

    private void initComponens(){
        textInputLayout = findViewById(R.id.inputTextLayout);
        imageView = findViewById(R.id.imageInputIcon);
    }


    public Editable getText(){
        return textInputLayout.getText();
    }

    public void setText(String text){
        textInputLayout.setText(text);
    }



//    public IconEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//
//    }
}
