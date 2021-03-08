package com.example.ktoma.bmi;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        Toolbar aboutMeToolbar = (Toolbar) findViewById(R.id.my_child_toolbar);
        setSupportActionBar(aboutMeToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.result_text);
        Bundle resultData = getIntent().getExtras();
        double res = resultData.getDouble("result_message");

        if(res <18.5) {
            setActivityBackgroundColor(Color.parseColor("#FFFF9091"));
            textView.setTextColor(Color.WHITE);
            textView.setText("" + new DecimalFormat("##.##").format(resultData.getDouble("result_message"))+ "\nYou're underweight.");
        }
        else if (res >= 18.5 && res < 25 ) {
            textView.setTextColor(Color.parseColor("##8AFF8A"));
            textView.setText("" + new DecimalFormat("##.##").format(resultData.getDouble("result_message"))+ "\nYour BMI is perfect!");
        }
        else {
            setActivityBackgroundColor(Color.parseColor("#FFFF9091"));
            textView.setTextColor(Color.WHITE);
            textView.setText("" + new DecimalFormat("##.##").format(resultData.getDouble("result_message")) + "\nYou're overweight.");
        }


    }
    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
