package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omelchenkoaleks.starttechopolice.R;

/*
    layout_constraintGuide_begin. Для вертикальных Guideline - отступ от левой стороны родителя.
    Для горизонтальных - от верхней стороны;

    layout_constraintGuide_end. Для вертикальных Guideline - отступ от правой стороны родителя.
    Для горизонтальных - от нижней стороны;

    layout_constraintGuide_percent. Относительный отступ Guideline в процентах.
    Для вертикальных Guideline - от левой стороны. Для горизонтальных - от верхней стороны.
    Указывается числом от 0 до 1.
 */
public class GuidelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideline);

        Button button = findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidelineActivity.this, BarrierActivity.class);
                startActivity(intent);
            }
        });
    }
}
