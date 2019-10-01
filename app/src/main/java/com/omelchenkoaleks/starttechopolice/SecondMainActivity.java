package com.omelchenkoaleks.starttechopolice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondMainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "SecondMainActivity";

    private EditText enterText;
    private TextView showText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        enterText = findViewById(R.id.editText);
        showText = findViewById(R.id.textView3);

        showText.setVisibility(View.INVISIBLE);

        Button sendText = findViewById(R.id.button);
        sendText.setOnClickListener(this);


        /* 1 SAMPLE */
//        Button sendText = findViewById(R.id.button);
//        sendText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String receivedText = enterText.getText().toString();
//                showText.setText(receivedText);
//                showText.setVisibility(View.VISIBLE);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        if (BuildConfig.LOG) Log.d(LOG_TAG, "SecondMainActivity.onClick: " + v);
        if (v.getId() == R.id.button) {
            onSubmitBtnClicked();
        }
    }

    private void onSubmitBtnClicked() {
        String receivedText = enterText.getText().toString();
        String concatenation = getString(R.string.hello_username, receivedText);
        showText.setText(concatenation);
        showText.setVisibility(View.VISIBLE);
    }
}
