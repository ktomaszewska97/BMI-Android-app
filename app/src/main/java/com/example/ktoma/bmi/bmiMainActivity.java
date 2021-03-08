package com.example.ktoma.bmi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class bmiMainActivity extends AppCompatActivity {

    EditText mass, height;
    Button go;
    Context context;
    Switch change;
    TextView ifEmpty;
    Toolbar myToolbar;
    SharedPreferences preferences;

    double massNum, heightNum;
    double resultNum;
    String savedText1, savedText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        context = getApplicationContext();
        preferences = getPreferences(Context.MODE_PRIVATE);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        change = (Switch) findViewById(R.id.change_for_feets);
        mass = (EditText) findViewById(R.id.mass_field);
        height = (EditText) findViewById(R.id.height_field);
        ifEmpty = (TextView) findViewById(R.id.true_false);

        go = (Button) findViewById(R.id.count_button);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isEmpty()) {
                massNum = Double.parseDouble(mass.getText().toString());
                heightNum = Double.parseDouble(height.getText().toString());

                    if (change.isChecked()) {
                        bmiForKg bfk = new bmiForKg(massNum, heightNum);

                        if (massNum < 30 || massNum > 200 || heightNum < 0.4 || heightNum > 2.5) {
                            mass.getText().clear();
                            height.getText().clear();
                            ifEmpty.setText("Hey, wrong data!");
                        }
                        else {
                            resultNum = bfk.count();
                            Intent result_intent = new Intent(context, resultActivity.class);
                            result_intent.putExtra("result_message", resultNum);
                            startActivity(result_intent);
                        }

                    } else {
                        bmiForFeetsAndPounds bffap = new bmiForFeetsAndPounds(massNum, heightNum);

                        if(massNum < 66 || massNum > 440 || heightNum < 16 || heightNum > 98.5) {
                            mass.getText().clear();
                            height.getText().clear();
                            ifEmpty.setText("Hey, wrong data!");
                        }
                        else {
                            resultNum = bffap.count();
                            Intent result_intent = new Intent(context, resultActivity.class);
                            result_intent.putExtra("result_message", resultNum);
                            startActivity(result_intent);
                        }

                    }
                }
                else {
                    ifEmpty.setText("Please, write your weight and height.");
                }

                }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_about_me) {

            Intent about_me_intent = new Intent(context, aboutMeActivity.class);
            startActivity(about_me_intent);

            return true;
        }

        if (id == R.id.action_save) {
            saveData();
        }

        if (id == R.id.action_restore) {
            restoreData();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void saveData() {
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        savedText1 = mass.getText().toString();
        preferencesEditor.putString("text_1", savedText1);
        savedText2 = height.getText().toString();
        preferencesEditor.putString("text_2", savedText2);
        preferencesEditor.commit();
    }

    private void restoreData() {
        String text1 = preferences.getString("text_1", "");
        mass.setText(text1);
        String text2 = preferences.getString("text_2", "");
        height.setText(text2);
    }

    public boolean isEmpty() {
        if(mass.getText().toString()==null || mass.getText().toString().trim().equals("") || height.getText().toString()==null || height.getText().toString().trim().equals("")) return true;
    return false;
    }

}
