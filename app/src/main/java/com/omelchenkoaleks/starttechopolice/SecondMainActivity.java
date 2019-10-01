package com.omelchenkoaleks.starttechopolice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondMainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        final EditText enterText = findViewById(R.id.editText);
        final TextView showText = findViewById(R.id.textView3);

        showText.setVisibility(View.INVISIBLE);

        Button sendText = findViewById(R.id.button);
        sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receivedText = enterText.getText().toString();
                showText.setText(receivedText);
                showText.setVisibility(View.VISIBLE);
            }
        });
    }
}
