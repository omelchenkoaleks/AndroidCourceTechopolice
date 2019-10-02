package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omelchenkoaleks.starttechopolice.R;

public class layout_constraintHorizontal_biasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_constraint_horizontal_bias);

        Button next = findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        layout_constraintHorizontal_biasActivity.this,
                        layout_constraintBaseline_toBaselineOfActivity.class);
                startActivity(intent);
            }
        });
    }
}
