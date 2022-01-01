package com.example.ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Harel Navon harelnavon2710@gmail.com
 * @version 1.0
 * @since 1/1/2022
 * This is a small application desgined to try out custom Activity Lifecycle
 * methods using a Shared Preferences file!!
 */

public class MainActivity extends AppCompatActivity {
    int count;
    EditText eT;
    TextView tV;
    String str;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        tV = findViewById(R.id.num);
        eT = findViewById(R.id.et);
        si = new Intent(this, credits.class);


    }

    @Override
    public void onStart() {
        super.onStart();
        settings = getSharedPreferences("pref", MODE_PRIVATE);
        count = settings.getInt("count", 0);
        str = settings.getString("str", "");
        tV.setText(count + "");
        eT.setText(str + "");


    }


    @Override
    public void onStop() {
        super.onStop();
        settings = getSharedPreferences("pref", MODE_PRIVATE);
        editor = settings.edit();
        editor.putInt("count", count);
        editor.putString("str", str);
        editor.commit();
    }


    public void plus(View view) {
        /**
        "Increments the counter and displays its current value."
         */

        count++;
        tV.setText(count + "");
    }


    public void reset(View view) {
        /**
         * Resets the counter and displays its value.
         */
        count = 0;
        tV.setText(0 + "");
    }


    public void close(View view) {
        /**
         * Closes the application.
         */
        str = eT.getText().toString();
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(si);
        return true;
    }
}