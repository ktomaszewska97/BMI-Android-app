package com.example.ktoma.bmi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

public class aboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me_activity);

        Toolbar myChildToolbar_me = (Toolbar) findViewById(R.id.about_me_toolbar);
        setSupportActionBar(myChildToolbar_me);
        ActionBar aboutMeActionBar = getSupportActionBar();
        aboutMeActionBar.setDisplayHomeAsUpEnabled(true);

    }
}
