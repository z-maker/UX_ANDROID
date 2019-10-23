package com.dynamic.uxmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dynamic.uiux.IconEditText;

public class MainActivity extends AppCompatActivity {

    private IconEditText username, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);

    }
}
