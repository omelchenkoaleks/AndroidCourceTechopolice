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

    @Override
    protected void onStart() {
        if (BuildConfig.LOG) Log.d(LOG_MAIN_ACTIVITY, getClass().getSimpleName() + " .onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        if (BuildConfig.LOG) Log.d(LOG_MAIN_ACTIVITY, getClass().getSimpleName() + " .onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (BuildConfig.LOG) Log.d(LOG_MAIN_ACTIVITY, getClass().getSimpleName() + " .onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (BuildConfig.LOG) Log.d(LOG_MAIN_ACTIVITY, getClass().getSimpleName() + " .onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (BuildConfig.LOG) Log.d(LOG_MAIN_ACTIVITY, getClass().getSimpleName() + " .onDestroy");
        super.onDestroy();
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
