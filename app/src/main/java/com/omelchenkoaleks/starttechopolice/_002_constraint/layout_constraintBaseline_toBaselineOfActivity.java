package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omelchenkoaleks.starttechopolice.R;

public class layout_constraintBaseline_toBaselineOfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_constraint_baseline_to_baseline_of);

        Button button = findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        layout_constraintBaseline_toBaselineOfActivity.this,
                        layout_constraintHorizontal_chainStyleActivity.class);
                startActivity(intent);
            }
        });
    }
}
