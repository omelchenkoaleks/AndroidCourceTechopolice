package com.omelchenkoaleks.starttechopolice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_MAIN_ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        if (BuildConfig.LOG) Log.d(LOG_MAIN_ACTIVITY, "onClick: ");

        if (view.getId() == R.id.send_test_activity_button) {

            Intent intentTest = new Intent(this, TestActivity.class);
            startActivity(intentTest);

        } else if (view.getId() == R.id.send_second_main_activity_button) {

            Intent intentSecond = new Intent(this, SecondMainActivity.class);
            startActivity(intentSecond);

        }
    }
}
