package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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


    }
}
