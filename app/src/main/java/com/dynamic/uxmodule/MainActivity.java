package com.dynamic.uxmodule;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.dynamic.uiux.IconEditText;
import com.dynamic.uiux.RoundedButton;
import com.dynamic.uiux.RoundedIconButton;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class MainActivity extends AppCompatActivity {

    private IconEditText username, email;

    private RoundedIconButton btn1, btn2;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);

        btn1 = findViewById(R.id.googleButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showFancy();

            }
        });

        btn2 = findViewById(R.id.facebookButton);

        if (getSupportActionBar() != null){
            actionBar = getSupportActionBar();
            actionBar.setTitle("Ux elements");
            actionBar.setLogo(R.mipmap.ic_launcher);
        }

    }

    private void showFancy(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }
}
