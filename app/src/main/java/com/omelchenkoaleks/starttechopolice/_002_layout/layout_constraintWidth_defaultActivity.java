package com.omelchenkoaleks.starttechopolice._002_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.starttechopolice.R;

public class layout_constraintWidth_defaultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_constraint_width_default);

        Button next = findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        layout_constraintWidth_defaultActivity.this,
                        layout_constraintHorizontal_biasActivity.class);
                startActivity(intent);
            }
        });
    }
}
