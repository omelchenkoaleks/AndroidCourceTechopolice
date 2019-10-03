package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omelchenkoaleks.starttechopolice.R;

/*
    Barrier – это невидимый View который применяется для нескольких объектов
    изначально неизвестного размера – если один из них увеличивается,
    то Barrier подстроит размер остальных под наибольшую высоту или ширину.
    Барьеры могут быть вертикальными и горизонтальными.
 */
public class BarrierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barrier);
    }
}
